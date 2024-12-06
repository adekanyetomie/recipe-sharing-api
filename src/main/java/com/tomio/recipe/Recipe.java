package com.tomio.recipe;

import com.tomio.recipe.image.RecipeImage;
import com.tomio.recipe.ingredient.RecipeIngredient;
import com.tomio.user.UserProfile;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;
    @Column(nullable = false, unique = true, length = 50, name = "username")
    private String username;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String cookingInstructions;
    @OneToMany(mappedBy = "recipe")
    private List<RecipeImage> images;
    @OneToMany(mappedBy = "recipe")
    private List<RecipeIngredient> ingredients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserProfile user;

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }


    public Recipe(){}

    public Recipe(Integer recipeId, String username, String name, String description, String cookingInstructions, List<RecipeImage> images, List<RecipeIngredient> ingredients) {
        this.recipeId = recipeId;
        this.username = username;
        this.name = name;
        this.description = description;
        this.cookingInstructions = cookingInstructions;
        this.images = images;
        this.ingredients = ingredients;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(String cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }

    public List<RecipeImage> getImages() {
        return images;
    }

    public void setImages(List<RecipeImage> images) {
        this.images = images;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe recipe)) return false;
        return Objects.equals(recipeId, recipe.recipeId) && Objects.equals(username, recipe.username) && Objects.equals(name, recipe.name) && Objects.equals(description, recipe.description) && Objects.equals(cookingInstructions, recipe.cookingInstructions) && Objects.equals(images, recipe.images) && Objects.equals(ingredients, recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, username, name, description, cookingInstructions, images, ingredients);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cookingInstructions='" + cookingInstructions + '\'' +
                ", images=" + images +
                ", ingredients=" + ingredients +
                '}';
    }
}
