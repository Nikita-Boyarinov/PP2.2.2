package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import web.models.Car;
import web.service.CarServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {
    final
    CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printTableCars(@RequestParam(value = "count", defaultValue = "5") String count, ModelMap modelMap) {
        if (Integer.parseInt(count) > 5) {
            modelMap.addAttribute("cars", carService.getCars("5"));
        } else {
            modelMap.addAttribute("cars", carService.getCars(count));
        }
        System.out.println(count);
        return "cars";
    }
}
