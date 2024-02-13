package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = AUTO)

    @Column(name="id_Courses")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name= "price")
    private float price;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }
}
