package com.automobileServiceStation.springBootApplication.controllers;

import com.automobileServiceStation.springBootApplication.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bikeService")
public class BikeServiceController implements VehicleServiceController {

    public BikeServiceController () {
        System.out.println(getClass().getSimpleName()+" instantiated");
    }
    private VehicleService vehicleService;

    @Autowired
    public void setBikeService (@Qualifier("bikeService")VehicleService vehicleService ) {
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
