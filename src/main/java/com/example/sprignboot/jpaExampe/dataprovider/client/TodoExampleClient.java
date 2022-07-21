package com.example.sprignboot.jpaExampe.dataprovider.client;
import java.util.List;

import com.example.sprignboot.jpaExampe.domain.model.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="Todos",url="https://jsonplaceholder.typicode.com")
public interface TodoExampleClient {
    @GetMapping(value="/todos",consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Todo>getTodos();
}
