package com.example.productsecurity.service;

import com.example.productsecurity.dao.MaintenanceRepository;
import com.example.productsecurity.entity.Maintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private MaintenanceRepository maintenanceRepository;

    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance findById(int maintenanceId) {
        Optional<Maintenance> result = maintenanceRepository.findById(maintenanceId);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find maintenance id - " + maintenanceId);
        }
    }

    @Override
    public void save(Maintenance maintenance) {
        maintenanceRepository.save(maintenance);
    }

    @Override
    public void deleteById(int maintenanceId) {
        maintenanceRepository.deleteById(maintenanceId);
    }
}
