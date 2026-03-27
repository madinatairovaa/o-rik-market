package com.backend.marketpractisetesting.Module;

import jakarta.persistence.*;

@Entity
@Table(name = "market_table")
public class MarketPractiseTestingModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private Double cost;

    private Integer quantity;

    private String image_url;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryTable category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }

    public CategoryTable getCategory() {
        return category;
    }

    public void setCategory(CategoryTable category) {
        this.category = category;
    }
}