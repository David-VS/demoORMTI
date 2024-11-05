package be.ehb.demoormti.dao;

import be.ehb.demoormti.entities.Drink;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrinkDao extends CrudRepository<Drink, Integer> {

    public List<Drink> findDistinctByName(String name);
}
