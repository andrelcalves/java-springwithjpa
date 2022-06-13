package com.example.sprignboot.jpaExampe.domain.model;

import com.example.sprignboot.jpaExampe.domain.model.enumerator.Color;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate createdDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private Color color;
    @ManyToOne
    private Category category;


    protected Product(){}

    public Product(String Name, String Description, BigDecimal Price, Color color, Category category){
        this.name = Name;
        this.description = Description;
        this.price = Price;
        this.color = color;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return this.category;
    }


}
