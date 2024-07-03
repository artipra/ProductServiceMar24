package com.scaler.firstspringapi.controllers;

import com.scaler.firstspringapi.exceptions.ProductNotFoundException;
import com.scaler.firstspringapi.models.Product;
import com.scaler.firstspringapi.services.ProductService;
import jdk.jfr.Percentage;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@SpringBootTest
//class ProductControllerTest {
//    @Autowired
//    private ProductController productController;
//
//    @MockBean // THis is going to be Mocked Object.
//    private ProductService productService;


//    @Test
//    void validGetProductByIdTest() throws ProductNotFoundException {
//        Product product = new Product();
//        product.setId(1L);
//        product.setTitle("Macbook pro");
//        product.setPrice(150000.0);
//        when(productService.getProductById(1L))
//                .thenReturn(product);
//        ResponseEntity<Product> responseEntity = productController.getProductById(1L);
//        Product actualProduct = responseEntity.getBody();
//        assertEquals(product, actualProduct);
//    }


    
//}