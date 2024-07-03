package com.scaler.firstspringapi.repositories;

import com.scaler.firstspringapi.models.Product;
import com.scaler.firstspringapi.projections.ProductWithTitleAndDescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long id);

    List<Product> findByTitle(String word);

    List<Product> findByTitleContains(String str);

    //select * from products where title = <> and description = <>
    List<Product> findByTitleAndDescription(String title, String description);

    Optional<Product> findByImage(String url);

    @Override
    void delete(Product entity);

    Product save(Product product); //create and update

    //HQL
    @Query("select p.title as title, p.description as description from Product p where p.id = :id")
    ProductWithTitleAndDescription someRandomQuery(@Param("id") Long id);

    //SQL Query -> native query
    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductWithTitleAndDescription someOtherRandomQuery(@Param("id") Long id);

    Page<Product> findAll(Pageable pageable);
}
