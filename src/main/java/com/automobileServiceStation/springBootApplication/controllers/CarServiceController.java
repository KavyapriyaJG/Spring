package com.automobileServiceStation.springBootApplication.controllers;

import com.automobileServiceStation.springBootApplication.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carService")
public class CarServiceController implements VehicleServiceController {
    private VehicleService vehicleService;

    @Autowired
    public CarServiceController(@Qualifier("carService")VehicleService vehicleService ) {
        System.out.println(getClass().getSimpleName()+" instantiated");
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
