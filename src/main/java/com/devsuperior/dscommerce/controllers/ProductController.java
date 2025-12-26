package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController{

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
        public ResponseEntity<ProductDTO> findProductById(@PathVariable Long id){
        //return "Hello World! Life is amazing with JESUS in charge!!! He saves, bro!!!";
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);//This is how to return the right HTTP code
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAllProducts(Pageable pageable){
        Page<ProductDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> insertProduct(@RequestBody ProductDTO dto){
        //return "Hello World! Life is amazing with JESUS in charge!!! He saves, bro!!!";
        dto = service.insertProduct(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
