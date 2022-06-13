package com.example.sprignboot.jpaExampe.infra.repository;

import com.example.sprignboot.jpaExampe.domain.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
