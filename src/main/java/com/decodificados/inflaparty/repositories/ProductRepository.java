package com.decodificados.inflaparty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decodificados.inflaparty.entities.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>{

    Optional<Product> findByNombre(String nombre);

}
