package com.scaler.firstspringapi.controllers;

import com.scaler.firstspringapi.common.AuthCommons;
import com.scaler.firstspringapi.dtos.UserDto;
import com.scaler.firstspringapi.exceptions.ProductNotFoundException;
import com.scaler.firstspringapi.models.Product;
import com.scaler.firstspringapi.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private ProductService productService;
    private AuthCommons authCommons;
    public ProductController(@Qualifier("selfProductService") ProductService productService, AuthCommons authCommons) {
        this.productService = productService;
        this.authCommons = authCommons;
    }


    //localhost:8080/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        ResponseEntity<Product> responseEntity;
//        if (product == null) {
//            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            return responseEntity;
//        }

//        Product sampleProduct = new Product();

//        ResponseEntity<Product> responseEntity = null;
//        try {
//            Product product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (ArithmeticException e) {
//            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        //Controllers should be as light as possible.
//        return responseEntity;
        //throw new RuntimeException("Something went wrong");
//        UserDto userDto = authCommons.validateToken(token);
//        if(userDto == null){
//            responseEntity = new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
//            return responseEntity;
//        }
        Product product = productService.getProductById(id);
        responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }

    // localhost:8080/products
    @GetMapping()
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {
        return productService.getAllProducts(pageNumber,pageSize);
    }

    //createProduct
    //deleteProduct
    //updateProduct -> Partial Update (PATCH)
    //replaceProduct -> Replace (PUT)

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Void> handleSomeException() {
        return null;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) { // can use DTO as well.
        return productService.createProduct(product);
    }

}
