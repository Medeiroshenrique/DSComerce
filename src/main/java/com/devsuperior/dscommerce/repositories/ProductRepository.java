package com.devsuperior.dscommerce.repositories;

import com.devsuperior.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA only requires the Entity and the type of the ID as parameters
public interface ProductRepository extends JpaRepository<Product, Long> {
}
