package br.com.backendpro.productms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.backendpro.productms.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
