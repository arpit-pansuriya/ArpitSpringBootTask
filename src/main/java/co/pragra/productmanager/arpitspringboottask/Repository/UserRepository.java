package co.pragra.productmanager.arpitspringboottask.Repository;

import co.pragra.productmanager.arpitspringboottask.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
