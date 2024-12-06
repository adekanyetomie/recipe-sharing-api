package com.tomio.recipe.ingredient;

import com.tomio.recipe.Recipe;
import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String recipeName;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private MeasurementUnit measurementUnit;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public RecipeIngredient() {}

    public RecipeIngredient(Integer id, String recipeName, Integer quantity, MeasurementUnit measurementUnit, Recipe recipe) {
        this.id = id;
        this.recipeName = recipeName;
        this.quantity = quantity;
        this.measurementUnit = measurementUnit;
        this.recipe = recipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredient that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(recipeName, that.recipeName) && Objects.equals(quantity, that.quantity) && measurementUnit == that.measurementUnit && Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeName, quantity, measurementUnit, recipe);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", quantity=" + quantity +
                ", measurementUnit=" + measurementUnit +
                ", recipe=" + recipe +
                '}';
    }
}
