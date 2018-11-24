package market.service;

import lombok.experimental.Delegate;
import market.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    @Delegate
    private PurchaseRepository purchaseRepository;
}
