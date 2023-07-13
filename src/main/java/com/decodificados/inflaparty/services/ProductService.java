package com.decodificados.inflaparty.services;

import com.decodificados.inflaparty.entities.Product;
import com.decodificados.inflaparty.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public final ProductRepository productRepo;
    @Autowired

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public Product createProduct(Product product){

        Product aux = null;

        if(productRepo.findByNombre(product.getNombre()).isEmpty()){
            aux = productRepo.save(product);
        }

        return aux;

    }

    public Optional<Product> readProduct(Long id){

        return productRepo.findById(id);

    }

    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    public Product deleteProduct(Long id){

        Product aux = null;

        if(productRepo.existsById(id)){
            aux = productRepo.findById(id).get();
            productRepo.deleteById(id);
        }

        return aux;

    }

}
