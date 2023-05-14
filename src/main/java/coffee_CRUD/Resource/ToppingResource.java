package coffee_CRUD.Resource;

import coffee_CRUD.Entity.Topping;
import coffee_CRUD.Repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topping")
public class ToppingResource {

    @Autowired
    ToppingRepository toppingRepository;

    @PostMapping("/create")
    public void create(@RequestBody Topping topping){
        toppingRepository.save(topping);
    }

    @GetMapping("/all")
    public List<Topping> getAll(){
        return toppingRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable Long id){
        toppingRepository.deleteById(id);
    }
}
