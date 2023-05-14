package coffee_CRUD.Entity;

import coffee_CRUD.Entity.enums.CoffeeBill;
import coffee_CRUD.Entity.enums.ToppingBill;
import coffee_CRUD.Entity.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "user_role", columnDefinition = "ENUM('CONSUMER','ADMIN')")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "user_id")
    private List<CoffeeBill> coffees = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "user_id")
    private List<ToppingBill> toppings = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "coffee(id)")
//    @OneToMany
//    private List<Coffee> coffeeBill = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "topping(id)")
//    private List<Topping> toppingBill = new ArrayList<>();
}
