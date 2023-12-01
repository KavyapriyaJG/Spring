package com.automobileServiceStation.springBootApplication.services;

import org.springframework.stereotype.Component;

@Component
public class CycleService implements VehicleService{

    @Override
    public String minorService() {
        return "Minor service from "+(getClass().getSimpleName());
    }

    @Override
    public String majorService() {
        return "Major service from "+(getClass().getSimpleName());
    }
}

