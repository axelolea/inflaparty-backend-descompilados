package com.decodificados.inflaparty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decodificados.inflaparty.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
