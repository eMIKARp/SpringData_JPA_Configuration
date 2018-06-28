package pl.mojaaplikacja;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.mojaaplikacja.model.Car;
import pl.mojaaplikacja.repository.CarRepository;

@Configuration
@ComponentScan
public class SpringDataAplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDataAplication.class);
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));
        
        CarRepository carRepo = ctx.getBean(CarRepository.class);
        cars.forEach(carRepo::save);
        
        Optional<Car> firstCar = carRepo.findById(2L);
   		carRepo.delete(firstCar.get());
   		
   		carRepo.findAll().forEach(System.out::println);
	}

}
