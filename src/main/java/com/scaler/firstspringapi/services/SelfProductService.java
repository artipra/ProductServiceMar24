package com.scaler.firstspringapi.services;

import com.scaler.firstspringapi.exceptions.ProductNotFoundException;
import com.scaler.firstspringapi.models.Category;
import com.scaler.firstspringapi.models.Product;
import com.scaler.firstspringapi.repositories.CategoryRepository;
import com.scaler.firstspringapi.repositories.ProductRepository;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository,
                       CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        //Fetch the product with the given id from DB.
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Product not found");
        }

        return optionalProduct.get();
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by("price").ascending()));
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        //Before saving the Product object in the DB, save the category object.

        Category category = product.getCategory();

        if (category.getId() == null) {
            //we need to save the category
//            Category savedCategory = categoryRepository.save(category);
//            product.setCategory(savedCategory);
        } else {
            //we should check if the category id is valid or not.
        }

        Product savedProduct =  productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(savedProduct.getCategory().getId());
        Category category1 = optionalCategory.get();
        savedProduct.setCategory(category1);
        return savedProduct;
    }

    @Override
    public void deleteProduct() {

    }
}
