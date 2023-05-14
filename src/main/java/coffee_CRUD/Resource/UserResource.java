package coffee_CRUD.Resource;


import coffee_CRUD.Entity.Coffee;
import coffee_CRUD.Entity.Topping;
import coffee_CRUD.Entity.User;
import coffee_CRUD.Entity.enums.CoffeeBill;
import coffee_CRUD.Entity.enums.ToppingBill;
import coffee_CRUD.Entity.enums.UserRole;
import coffee_CRUD.Helper.CustomPair;
import coffee_CRUD.Repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CoffeeRepository coffeeRepository;

    @Autowired
    CoffeeBillRepository coffeeBillRepository;

    @Autowired
    ToppingRepository toppingRepository;

    @Autowired
    ToppingBillRepository toppingBillRepository;

    @PostMapping("/create")
    public void create(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/{id}/byCoffee")
    public void byCoffee(@PathVariable Long id, @RequestBody Coffee coffee){

        User old = userRepository.findById(id).get();
        Coffee oldCoffee = coffeeRepository.findById(coffee.getId()).get();

        CoffeeBill coffeeBill = new CoffeeBill();

        coffeeBill.setName(coffee.getName());
        coffeeBill.setAmount(coffee.getAmount());
        coffeeBill.setId(coffee.getId());

        coffeeBillRepository.save(coffeeBill);

        old.getCoffees().add(coffeeBill);

        oldCoffee.setAmount(oldCoffee.getAmount() - coffee.getAmount());

        userRepository.save(old);
        coffeeRepository.save(oldCoffee);
    }

    @PutMapping("/{id}/upCoffee")
    public @ResponseBody String upCoffee(@RequestBody Coffee coffee, @PathVariable Long id){
        if(userRepository.findById(id).get().getUserRole().equals(UserRole.ADMIN)){
            coffeeRepository.save(coffee);
            return "Success";
        }
        return "Only Admin can add amount";
    }

    @GetMapping("/{id}/bill")
    public CustomPair bill(@PathVariable Long id){
        CustomPair customPair = new CustomPair();
        customPair.setCoffeeBills(
            userRepository.findById(id).get().getCoffees()
        );
        customPair.setToppingBills(
                userRepository.findById(id).get().getToppings()
        );
        return customPair;
    }


    @PostMapping("/{id}/byTopping")
    public void byTopping(@PathVariable Long id, @RequestBody Topping topping){

        User old = userRepository.findById(id).get();
        Topping oldTopping = toppingRepository.findById(topping.getId()).get();

        ToppingBill toppingBill = new ToppingBill();

        toppingBill.setName(topping.getName());
        toppingBill.setAmount(topping.getAmount());
        toppingBill.setId(topping.getId());

        toppingBillRepository.save(toppingBill);

        old.getToppings().add(toppingBill);

        oldTopping.setAmount(oldTopping.getAmount() - topping.getAmount());

        userRepository.save(old);
        toppingRepository.save(oldTopping);
    }

    @PutMapping("/{id}/upTopping")
    public @ResponseBody String upTopping(@RequestBody Topping topping, @PathVariable Long id){
        if(userRepository.findById(id).get().getUserRole().equals(UserRole.ADMIN)){
            toppingRepository.save(topping);
            return "Success";
        }
        return "Only Admin can add amount";
    }
}
