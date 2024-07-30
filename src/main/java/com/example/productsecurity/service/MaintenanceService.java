package com.example.productsecurity.service;

import com.example.productsecurity.entity.Maintenance;
import java.util.List;

public interface MaintenanceService {

    List<Maintenance> findAll();

    Maintenance findById(int theId);

    void save(Maintenance theMaintenance);

    void deleteById(int theId);

}
