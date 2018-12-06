package es.whinedo.pilots.springboot_docker.simple.repository;

import es.whinedo.pilots.springboot_docker.simple.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
