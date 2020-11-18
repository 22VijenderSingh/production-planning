package com.vj.productionplanning.model;

public class SimulationResult {

  VisitResult[] visitResults;

  public SimulationResult(VisitResult[] visitResults) {
    this.visitResults = visitResults;
  }

  public VisitResult[] getVisits() {
    return visitResults;
  }
}
