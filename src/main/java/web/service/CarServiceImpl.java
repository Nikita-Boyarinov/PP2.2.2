package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl {
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car("Mazda", 2012, "Red"));
        cars.add(new Car("BMW", 2015, "Black"));
        cars.add(new Car("Toyota", 2020, "White"));
        cars.add(new Car("LADA", 1999, "Baklazan"));
        cars.add(new Car("Volvo", 2022, "Grey"));
    }

    public List<Car> getCars(String count) {
        return cars.subList(0, Integer.parseInt(count));
    }
}