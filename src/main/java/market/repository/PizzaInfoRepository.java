package market.repository;

import market.entity.PizzaInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaInfoRepository extends CrudRepository<PizzaInfo, Long> {

}