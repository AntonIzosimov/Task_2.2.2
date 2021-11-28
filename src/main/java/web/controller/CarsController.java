package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;

@Controller

public class CarsController {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String showCarList(Model model) {
        model.addAttribute("carList", carService.getAllCars());
        return "cars";
    }

    @RequestMapping(value = "/cars", params = "count")
    public String carsCount(Model model, int count) {
        model.addAttribute("carCount", carService.getCarsCount(count));
        return "carsCount";
    }
}
