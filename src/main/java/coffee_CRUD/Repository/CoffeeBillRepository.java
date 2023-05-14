package coffee_CRUD.Repository;

import coffee_CRUD.Entity.enums.CoffeeBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeBillRepository extends JpaRepository<CoffeeBill, Long> {
}
