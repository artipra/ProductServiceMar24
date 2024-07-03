package com.scaler.firstspringapi.services;

import com.scaler.firstspringapi.dtos.FakeStoreProductDto;
import com.scaler.firstspringapi.exceptions.ProductNotFoundException;
import com.scaler.firstspringapi.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ProductService {

    Product getProductById(Long id) throws ProductNotFoundException;

    Page<Product> getAllProducts(int pageNumber, int pageSize);

    Product updateProduct(Long id, Product product);

    Product replaceProduct(Long id, Product product);

    Product createProduct(Product product);

    void deleteProduct();

}
