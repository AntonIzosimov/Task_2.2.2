package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    private List<Car> carList = new ArrayList<>();

    {
        carList.add(new Car("Копейка", "Бежевый", 150));
        carList.add(new Car("Двойка", "Серебро", 200));
        carList.add(new Car("Тройка", "Мрамор", 348));
        carList.add(new Car("Четверка", "Карамель", 120));
        carList.add(new Car("Пятерка", "Вишня", 80));
    }

    public List<Car> getAllCars() {
        return carList;
    }

    public List<Car> getCarsCount(int count) {
        List<Car> cars = new ArrayList<>(carList);
        if(count < 5) {
            return cars.stream().limit(count).collect(Collectors.toList());
        } else {
            return cars;
        }
    }
}
