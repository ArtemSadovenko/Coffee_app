package coffee_CRUD.Resource;

import coffee_CRUD.Entity.Coffee;
import coffee_CRUD.Repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeResource {

    @Autowired
    CoffeeRepository coffeeRepository;

    @PostMapping("/create")
    public void create(@RequestBody Coffee coffee){
        coffeeRepository.save(coffee);
    }

    @GetMapping("/all")
    public List<Coffee> getAll(){
        return coffeeRepository.findAll();
    }

}
