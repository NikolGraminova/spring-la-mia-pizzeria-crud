package org.web.springlamiapizzeriacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.web.springlamiapizzeriacrud.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
