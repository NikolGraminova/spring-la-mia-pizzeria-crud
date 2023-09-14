package org.web.springlamiapizzeriacrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web.springlamiapizzeriacrud.model.Pizza;
import org.web.springlamiapizzeriacrud.repository.PizzaRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> pizzaList = pizzaRepository.findAll();
        model.addAttribute("pizzas", pizzaList);
        return "pizza-list";
    }
}
