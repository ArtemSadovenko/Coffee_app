package coffee_CRUD.Repository;

import coffee_CRUD.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
