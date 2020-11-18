package com.vj.productionplanning.model;

public class VisitTime {

  private int hour;
  private int minutes;

  public VisitTime(int hour, int minutes) {
    this.hour = hour;
    this.minutes = minutes;
  }

  public int getHour() {
    return hour;
  }

  public int getMinutes() {
    return minutes;
  }
}
