package market.controller;

import market.entity.Id;
import market.entity.Purchase;
import market.entity.PizzaInfo;
import market.entity.PricePerWeight;
import market.service.PurchaseService;
import market.service.PizzaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class InfoController {

    @Autowired
    private PizzaInfoService pizzaInfoService;
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping(value = "/health")
    public String health() {
        return "Healthy";
    }

    @GetMapping(value = "/init")
    public void init() {
        pizzaInfoService.save(getInitData());
    }

    private List<PizzaInfo> getInitData() {
        List<PizzaInfo> pizzaInfos = new ArrayList<>();

        pizzaInfos.add(PizzaInfo.builder()
                .name("Пицца Пеперони с  томатами")
                .ingridients(Arrays.asList("моцарелла", "пеперони", "помидоры","соус барбекю"))
                .pricePerWeight(Arrays.asList(
                        new PricePerWeight(22, 90),
                        new PricePerWeight(30, 150),
                        new PricePerWeight(36, 189)
                ))
                .imgUrl("/0001.jpg")
                .build());

        pizzaInfos.add(PizzaInfo.builder()
                .name("Пицца Техас")
                .ingridients(Arrays.asList("кукуруза", "моцарелла", "лук", "грибы", "колбаски баварские", "соус барбекю"))
                .pricePerWeight(Arrays.asList(
                        new PricePerWeight(22, 80),
                        new PricePerWeight(30, 154),
                        new PricePerWeight(36, 189)
                ))
                .imgUrl("/0002.jpg")
                .build());

        pizzaInfos.add(PizzaInfo.builder()
                .name("Пицца Гавайская")
                .ingridients(Arrays.asList("курица", "моцарелла", "ананас", "фирменный соус"))
                .pricePerWeight(Arrays.asList(
                        new PricePerWeight(22, 109),
                        new PricePerWeight(30, 169),
                        new PricePerWeight(36, 214)
                ))
                .imgUrl("/0003.jpg")
                .build());

        pizzaInfos.add(PizzaInfo.builder()
                .name("Пицца Прованс")
                .ingridients(Arrays.asList("моцарелла", "бергадер блю", "шинка", "пеперони", "помидоры", "соус альфредо"))
                .pricePerWeight(Arrays.asList(
                        new PricePerWeight(22, 129),
                        new PricePerWeight(30, 194),
                        new PricePerWeight(36, 224)
                ))
                .imgUrl("/0004.jpg")
                .build());

        pizzaInfos.add(PizzaInfo.builder()
                .name("Пицца Пеперони блюз")
                .ingridients(Arrays.asList("моцарелла", "бергадер блю", "пеперони",  "соус альфредо"))
                .pricePerWeight(Arrays.asList(
                        new PricePerWeight(22, 109),
                        new PricePerWeight(30, 164),
                        new PricePerWeight(36, 214)
                ))
                .imgUrl("/0005.jpg")
                .build());

        pizzaInfos.add(PizzaInfo.builder()
                .name("Пицца Пять сыров")
                .ingridients(Arrays.asList("фета", "моцарелла", "пармезан",  "бергадер блю", "соус альфредо" , "чедер"))
                .pricePerWeight(Arrays.asList(
                        new PricePerWeight(22, 164),
                        new PricePerWeight(30, 234),
                        new PricePerWeight(36, 269)
                ))
                .imgUrl("/0006.jpg")
                .build());

        return pizzaInfos;
    }

    @GetMapping(value = "/pizzas", produces = "application/json")
    public Iterable<PizzaInfo> findAll() {
        return pizzaInfoService.findAll();
    }

    @PostMapping(value = "/purchases", consumes = "application/json", produces = "application/json")
    public Id save(@RequestBody Purchase purchase) {
        purchaseService.save(purchase);
        System.out.println(purchase);
        return new Id(purchase.getId());
    }
}
