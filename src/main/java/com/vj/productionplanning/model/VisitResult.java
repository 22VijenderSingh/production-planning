package com.vj.productionplanning.model;

public class VisitResult {

  private int visitNumber;
  private VisitTime visitTime;
  private int randomNumber;
  private String serviceRequired;
  private int duration;
  private VisitTime startTime;
  private VisitTime endTime;
  private VisitTime patientWaitingTime;
  private VisitTime doctorIdleTime;

  public VisitResult(int visitNumber, VisitTime visitTime, int randomNumber,
      String serviceRequired, int duration, VisitTime startTime,
      VisitTime endTime, VisitTime patientWaitingTime,
      VisitTime doctorIdleTime) {
    this.visitNumber = visitNumber;
    this.visitTime = visitTime;
    this.randomNumber = randomNumber;
    this.serviceRequired = serviceRequired;
    this.duration = duration;
    this.startTime = startTime;
    this.endTime = endTime;
    this.patientWaitingTime = patientWaitingTime;
    this.doctorIdleTime = doctorIdleTime;
  }

  public int getVisitNumber() {
    return visitNumber;
  }

  public VisitTime getVisitTime() {
    return visitTime;
  }

  public int getRandomNumber() {
    return randomNumber;
  }

  public String getServiceRequired() {
    return serviceRequired;
  }

  public int getDuration() {
    return duration;
  }

  public VisitTime getStartTime() {
    return startTime;
  }

  public VisitTime getEndTime() {
    return endTime;
  }

  public VisitTime getPatientWaitingTime() {
    return patientWaitingTime;
  }

  public VisitTime getDoctorIdleTime() {
    return doctorIdleTime;
  }
}
