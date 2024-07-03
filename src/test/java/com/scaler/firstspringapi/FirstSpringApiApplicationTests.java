//package com.scaler.firstspringapi;
//
//import com.scaler.firstspringapi.models.Category;
//import com.scaler.firstspringapi.models.Product;
//import com.scaler.firstspringapi.projections.ProductWithTitleAndDescription;
//import com.scaler.firstspringapi.repositories.CategoryRepository;
//import com.scaler.firstspringapi.repositories.ProductRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//class FirstSpringApiApplicationTests {
////    @Autowired
////    private CategoryRepository categoryRepository;
////
////    @Autowired
////    private ProductRepository productRepository;
//
//    @Test
//    void contextLoads() {
//    }
//
////    @Test
////    @Transactional
////    public void testTC() {
////        Optional<Category> optionalCategory = categoryRepository.findById(1L);
////
////        Category category = optionalCategory.get();
////
////        System.out.println("Fetching products related to the above category");
////        List<Product> products = category.getProducts();
//////        System.out.println(products.get(0).getTitle());
////
////        ProductWithTitleAndDescription productWithTitleAndDescription
////                = productRepository.someRandomQuery(2L);
////
////        System.out.println(productWithTitleAndDescription.getTitle());
////        System.out.println(productWithTitleAndDescription.getDescription());
////
////        ProductWithTitleAndDescription product =
////                productRepository.someOtherRandomQuery(2L);
////
////        System.out.println(product.getTitle());
////        System.out.println(product.getDescription());
////        System.out.println("DEBUG");
////    }
//
//}
