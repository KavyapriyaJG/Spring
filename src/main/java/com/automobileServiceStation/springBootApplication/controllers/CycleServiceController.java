package com.automobileServiceStation.springBootApplication.controllers;

import com.automobileServiceStation.springBootApplication.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import com.automobileServiceStation.springBootApplication.services.CycleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cycleService")
public class CycleServiceController implements VehicleServiceController {

//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//    CycleService cycleService = applicationContext.getBean("cycleService", CycleService.class);

    private VehicleService vehicleService;

    // Constructor-based injection for CycleService
    @Autowired
    public CycleServiceController(@Qualifier("cycleService") VehicleService cycleService) {
        this.vehicleService = cycleService;
    }

    // Setter-based injection for CycleService
    @Autowired
    public void setCycleService (@Qualifier("cycleService")VehicleService vehicleService ) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/minor")
    public String minorVehicleService() {
        return vehicleService.minorService();
    }

    @GetMapping("/major")
    public String majorVehicleService() {
        return vehicleService.majorService();
    }
}