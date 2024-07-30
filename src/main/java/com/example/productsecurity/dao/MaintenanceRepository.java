package com.example.productsecurity.dao;

import com.example.productsecurity.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {

    List<Maintenance> findAllByOrderByMaintenanceIdAsc();

}
