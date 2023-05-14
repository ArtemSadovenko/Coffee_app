package coffee_CRUD.Helper;

import coffee_CRUD.Entity.enums.CoffeeBill;
import coffee_CRUD.Entity.enums.ToppingBill;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomPair {
    List<CoffeeBill> coffeeBills = new ArrayList<>();
    List<ToppingBill> toppingBills = new ArrayList<>();
}
