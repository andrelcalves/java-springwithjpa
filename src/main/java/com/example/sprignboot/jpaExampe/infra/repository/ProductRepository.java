package com.example.sprignboot.jpaExampe.infra.repository;

import com.example.sprignboot.jpaExampe.domain.model.Product;
import org.springframework.data.repository.CrudRepository;
import java.math.BigDecimal;

public interface ProductRepository extends CrudRepository<Product, BigDecimal> {

}
