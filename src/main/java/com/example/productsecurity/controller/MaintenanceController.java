package com.example.productsecurity.controller;

import com.example.productsecurity.entity.Maintenance;
import com.example.productsecurity.service.MaintenanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@Controller
@RequestMapping("/maintenances")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService theMaintenanceService) {
        maintenanceService = theMaintenanceService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listMaintenances(Model theModel) {
        // get maintenances from db
        List<Maintenance> theMaintenances = maintenanceService.findAll();

        // add to the spring model
        theModel.addAttribute("maintenances", theMaintenances);

        return "maintenances/list-maintenances";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Maintenance theMaintenance = new Maintenance();

        theModel.addAttribute("maintenance", theMaintenance);

        return "maintenances/maintenance-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("maintenanceId") int theId, Model theModel) {
        // get the maintenance from the service
        Maintenance theMaintenance = maintenanceService.findById(theId);

        // set maintenance as a model attribute to pre-populate the form
        theModel.addAttribute("maintenance", theMaintenance);

        // send over to our form
        return "maintenances/maintenance-form";
    }

    @PostMapping("/save")
    public String saveMaintenance(@ModelAttribute("maintenance") Maintenance theMaintenance) {
        // save the maintenance
        maintenanceService.save(theMaintenance);

        // use a redirect to prevent duplicate submissions
        return "redirect:/maintenances/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("maintenanceId") int theId) {
        // delete the maintenance
        maintenanceService.deleteById(theId);

        // redirect to /maintenances/list
        return "redirect:/maintenances/list";
    }
}
