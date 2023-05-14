package coffee_CRUD.Repository;

import coffee_CRUD.Entity.enums.ToppingBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingBillRepository extends JpaRepository<ToppingBill, Long> {
}
