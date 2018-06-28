package pl.mojaaplikacja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.mojaaplikacja.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>{

}
