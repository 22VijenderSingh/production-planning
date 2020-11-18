package com.vj.productionplanning.service;

import com.vj.productionplanning.model.Service;
import com.vj.productionplanning.model.SimulationRequest;
import com.vj.productionplanning.model.SimulationResult;
import com.vj.productionplanning.model.TimeSlot;
import com.vj.productionplanning.model.VisitResult;
import com.vj.productionplanning.model.VisitTime;
import java.util.Random;

@org.springframework.stereotype.Service
public class Session {
  private Service[] services= new Service[5];
  private int servicesCount=0;
  private int currentTimeInMinutes;

  public Session(){
    addService(new Service("Filling",45,0.40));
    addService(new Service("Crown", 60, 0.15));
    addService(new Service("Cleaning", 15, 0.15));
    addService(new Service("Extraction", 45, 0.10));
    addService(new Service("Checkup", 15, 0.20));
    currentTimeInMinutes=480;
  }

  private void addService(Service  s){
    if(servicesCount==0){
      s.setCumulativeProbability(s.getProbability());
    }else{
      s.setCumulativeProbability(s.getProbability()+services[servicesCount-1].getCumulativeProbability());
    }
    s.setMaxRange((int)(s.getCumulativeProbability()*100));
    services[servicesCount++]=s;
  }

  private Service getService(int randomNumber){
    for(int i =0; i< servicesCount; i++) {
      if (randomNumber <= services[i].getMaxRange()) {
        return services[i];
      }
    }
    return null;
  }

  private VisitResult visit(int countNumber, VisitTime visitTime){
    Random random= new Random();
    int randomNumber = random.nextInt(100);
    Service service= getService(randomNumber);
    TimeSlot timeSlot = new TimeSlot(visitTime.getHour()*60 + visitTime.getMinutes(), currentTimeInMinutes, service.getTimeRequired());
    currentTimeInMinutes = timeSlot.getEndTimeOfService();
    String serviceRequired = service.getCategoryOfService();
    int duration = service.getTimeRequired();
    VisitTime startTime = new VisitTime(timeSlot.getStartTimeOfService()/60, timeSlot.getStartTimeOfService()%60);
    VisitTime endTime = new VisitTime(timeSlot.getEndTimeOfService()/60, timeSlot.getEndTimeOfService()%60);
    VisitTime waitingTimeOfPatient = new VisitTime(timeSlot.getWaitingTimeOfPatient()/60, timeSlot.getWaitingTimeOfPatient()%60);
    VisitTime idleTimeOfDoctor = new VisitTime(timeSlot.getIdleTimeOfDoctor()/60, timeSlot.getIdleTimeOfDoctor()%60);
    return new VisitResult(countNumber, visitTime, randomNumber, serviceRequired, duration, startTime, endTime, waitingTimeOfPatient, idleTimeOfDoctor);
  }

  public SimulationResult runSimulation(SimulationRequest request) {

    VisitTime[] visits = request.getVisits();

    VisitResult[] visitResults = new VisitResult[visits.length];

    for (int i=0; i<visits.length; i++) {
      visitResults[i] = visit(i, visits[i]);
    }

    return new SimulationResult(visitResults);
  }
}
