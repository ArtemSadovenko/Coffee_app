package coffee_CRUD.Resource;


import coffee_CRUD.Entity.Coffee;
import coffee_CRUD.Entity.User;
import coffee_CRUD.Repository.CoffeeRepository;
import coffee_CRUD.Repository.UserRepository;
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

    @PostMapping("/create")
    public void create(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/{id}/byCoffee")
    public @ResponseBody String byCoffee(@PathVariable Long id, @RequestBody Coffee coffee){
//        Coffee old = coffeeRepository.findById(coffee.getId()).get();
//        User user = userRepository.findById(id).get();
//
//        Coffee cof = new Coffee();
//        cof.setId(coffee.getId());
//        cof.setName(coffee.getName());
//        cof.setAmount(old.getAmount() - coffee.getAmount());
//
//        user.getCoffees().add(coffee);
////
////        old.setAmount(old.getAmount() - coffee.getAmount());
//
//        coffeeRepository.save(cof);
//        userRepository.save(user);

        Coffee coffee1 = coffeeRepository.findById(coffee.getId()).get();
        User user = userRepository.findById(id).get();

        user.getCoffees().add(coffee);

        coffee1.setAmount(coffee1.getAmount()- coffee.getAmount());

        String res = String.valueOf(coffee1.getAmount());

        userRepository.save(user);
        coffeeRepository.save(coffee1);

        return res;
    }

}
