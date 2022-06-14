package com.example.sprignboot.jpaExampe.infra.repository;

import com.example.sprignboot.jpaExampe.domain.model.Category;
import com.example.sprignboot.jpaExampe.domain.model.Product;
import org.springframework.data.repository.CrudRepository;
import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, BigDecimal> {
    Product findById(long id);
    Product findByName(String name);
    List<Product> findByCategory(Category category);
}
