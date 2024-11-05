package be.ehb.demoormti.controller;

import be.ehb.demoormti.dao.DrinkDao;
import be.ehb.demoormti.entities.Drink;
import be.ehb.demoormti.entities.TastingNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkAPIController {

    private DrinkDao myDrinkDao;

    @Autowired
    public DrinkAPIController(DrinkDao myDrinkDao) {
        this.myDrinkDao = myDrinkDao;
    }

    @GetMapping
    public Iterable<Drink> getAllDrinks() {
        return myDrinkDao.findAll();
    }

    @GetMapping("/{id}")
    public List<TastingNotes> tastingNotesForDrink(@PathVariable int id){
        if(myDrinkDao.existsById(id)){
            Drink myDrink = myDrinkDao.findById(id).get();
            return myDrink.getTastingNotes();
        } else {
            return null;
        }
    }
}
