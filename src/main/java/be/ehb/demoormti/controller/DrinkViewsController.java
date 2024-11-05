package be.ehb.demoormti.controller;

import be.ehb.demoormti.dao.DrinkDao;
import be.ehb.demoormti.entities.Drink;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DrinkViewsController {

    private DrinkDao myDrinkDao;

    @Autowired
    public DrinkViewsController(DrinkDao myDrinkDao) {
        this.myDrinkDao = myDrinkDao;
    }

    /*
    @ModelAttribute("allDrinks")
    public Iterable getAllDrinks() {
        return myDrinkDao.findAll();
    }
    */

    @GetMapping({"/", "", "/index"})
    public String showIndex(ModelMap myModelMap) {
        myModelMap.addAttribute("allDrinks", myDrinkDao.findAll());
        return "index";
    }

    @ModelAttribute("newDrink")
    public Drink newDrink() {
        return new Drink();
    }

    @PostMapping("/index")
    public String addDrink(@ModelAttribute("newDrink") @Valid Drink newDrink,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "index";
        }
        myDrinkDao.save(newDrink);
        return "redirect:/index";
    }
}
