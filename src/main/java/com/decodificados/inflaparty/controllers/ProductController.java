package com.decodificados.inflaparty.controllers;


import com.decodificados.inflaparty.entities.Product;
import com.decodificados.inflaparty.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequestMapping(path = "products")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        System.out.println(product);
        return productService.createProduct(product);
    }

    @GetMapping(path = "/{idProd}")
    public Optional<Product> getProductWithId(@PathVariable("idProd") Long id){
        return productService.readProduct(id);
    }

    @GetMapping
    public List<Product> getListProducts (){
        return productService.findAllProducts();
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }


}
