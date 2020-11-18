package com.vj.productionplanning.model;

public class Service {
  private String categoryOfService;
  private int timeRequired;
  private double probability;
  private double cumulativeProbability;
  private int maxRange;

  public Service(String categoryOfService, int timeRequired, double probability) {
    this.categoryOfService = categoryOfService;
    this.timeRequired = timeRequired;
    this.probability = probability;
  }

  public void setCumulativeProbability(double cumulativeProbability) {
    this.cumulativeProbability = cumulativeProbability;
  }

  public void setMaxRange(int maxRange) {
    this.maxRange = maxRange;
  }

  public String getCategoryOfService() {
    return categoryOfService;
  }

  public int getTimeRequired() {
    return timeRequired;
  }

  public double getProbability() {
    return probability;
  }

  public double getCumulativeProbability() {
    return cumulativeProbability;
  }

  public int getMaxRange() {
    return maxRange;
  }
}
