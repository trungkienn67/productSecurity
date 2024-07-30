package com.example.productsecurity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintenance_id")
    private int maintenanceId;

    @Column(name = "car_id")
    private String carId;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private String cost;

    @Column(name = "maintenance_type")
    private String maintenanceType;

    // Constructors, getters, setters, and toString method
    // Make sure to define appropriate getters and setters for all fields

    public Maintenance() {
    }

    public Maintenance(String carId, String description, String cost, String maintenanceType) {
        this.carId = carId;
        this.description = description;
        this.cost = cost;
        this.maintenanceType = maintenanceType;
    }

    public Maintenance(int maintenanceId, String carId, String description, String cost, String maintenanceType) {
        this.maintenanceId = maintenanceId;
        this.carId = carId;
        this.description = description;
        this.cost = cost;
        this.maintenanceType = maintenanceType;
    }

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceId=" + maintenanceId +
                ", carId='" + carId + '\'' +
                ", description='" + description + '\'' +
                ", cost='" + cost + '\'' +
                ", maintenanceType='" + maintenanceType + '\'' +
                '}';
    }
}
