package market.service;

import lombok.experimental.Delegate;
import market.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    @Delegate
    private PizzaRepository pizzaRepository;
}
