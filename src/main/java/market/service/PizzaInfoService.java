package market.service;

import lombok.experimental.Delegate;
import market.repository.PizzaInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaInfoService {

    @Autowired
    @Delegate
    private PizzaInfoRepository pizzaInfoRepository;
}
