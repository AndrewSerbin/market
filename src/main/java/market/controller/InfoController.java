package market.controller;

import market.entity.Id;
import market.entity.Purchase;
import market.entity.PizzaInfo;
import market.service.PurchaseService;
import market.service.PizzaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InfoController {

    @Autowired
    private PizzaInfoService pizzaInfoService;
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping(value = "/pizzas", produces = "application/json")
    public Iterable<PizzaInfo> findAll() {
        return pizzaInfoService.findAll();
    }

    @PostMapping(value = "/purchases", consumes = "application/json", produces = "application/json")
    public Id save(@RequestBody Purchase purchase) {
        purchaseService.save(purchase);
        return new Id(purchase.getId());
    }
}
