package org.web.springlamiapizzeriacrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.web.springlamiapizzeriacrud.model.Pizza;
import org.web.springlamiapizzeriacrud.repository.PizzaRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/list")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> pizzaList = pizzaRepository.findAll();
        model.addAttribute("pizzas", pizzaList);
        return "pizzas/list";
    }

    @GetMapping("/show/{pizzaId}")
    public String show(@PathVariable("pizzaId") Integer id, Model model) {
        Optional<Pizza> pizzaOptional = pizzaRepository.findById(id);
        if (pizzaOptional.isPresent()) {
            Pizza pizzaFound = pizzaOptional.get();
            model.addAttribute("pizza", pizzaFound);
            return "pizzas/details";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "pizzas/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult) {

        pizzaRepository.save(formPizza);
        return "redirect:/list";
    }

}
