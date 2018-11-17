package market.controller;

import market.entity.Pizza;
import market.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping(value = "/health")
    public String hello() {
        return "Healthy";
    }

    @GetMapping(value = "/pizzas", produces = "application/json")
    public Iterable<Pizza> findAll() {
        return pizzaService.findAll();
    }

//    @GetMapping(value = "/books/{id}", produces = "application/json")
//    public Pizza findOne(@PathVariable Long id) {
//        return pizzaService.findOne(id);
//    }
//
//    @PostMapping(value = "/books", consumes = "application/json")
//    public void save(@RequestBody Pizza book) {
//        pizzaService.save(book);
//    }
//
//    @PutMapping(value = "/books/{id}", consumes = "application/json")
//    public void update(@RequestBody Pizza book, @PathVariable Long id) {
//        if (pizzaService.exists(id)) {
//            book.setId(id);
//            pizzaService.save(book);
//        }
//    }
//
//    @DeleteMapping(value = "/books/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void update(@PathVariable Long id) {
//        if (pizzaService.exists(id)) {
//            pizzaService.delete(id);
//        }
//    }
}
