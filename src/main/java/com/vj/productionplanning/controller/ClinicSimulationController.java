package com.vj.productionplanning.controller;

import com.vj.productionplanning.model.SimulationRequest;
import com.vj.productionplanning.model.SimulationResult;
import com.vj.productionplanning.service.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simulation/clinic")
public class ClinicSimulationController {

  private Session session;

  @Autowired
  public ClinicSimulationController(Session session) {
    this.session = session;
  }

  @RequestMapping(path = "/run", method = RequestMethod.POST)
  public SimulationResult runSimulation(@RequestBody SimulationRequest request) {
    return session.runSimulation(request);
  }
}
