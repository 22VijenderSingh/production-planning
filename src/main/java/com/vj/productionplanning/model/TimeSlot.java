package com.vj.productionplanning.model;

public class TimeSlot {
  private int startTimeOfService;
  private int endTimeOfService;
  private int idleTimeOfDoctor;
  private int waitingTimeOfPatient;

  public TimeSlot(int arrivalTimeInMinutes, int currentTimeInMinutes, int serviceTime){
    idleTimeOfDoctor = currentTimeInMinutes<arrivalTimeInMinutes ? arrivalTimeInMinutes-currentTimeInMinutes : 0;
    waitingTimeOfPatient = arrivalTimeInMinutes<currentTimeInMinutes ? currentTimeInMinutes-arrivalTimeInMinutes : 0;
    startTimeOfService= Math.max(arrivalTimeInMinutes, currentTimeInMinutes);
    endTimeOfService= startTimeOfService+serviceTime;
  }

  public int getStartTimeOfService() {
    return startTimeOfService;
  }

  public int getEndTimeOfService() {
    return endTimeOfService;
  }

  public int getIdleTimeOfDoctor() {
    return idleTimeOfDoctor;
  }

  public int getWaitingTimeOfPatient() {
    return waitingTimeOfPatient;
  }
}
