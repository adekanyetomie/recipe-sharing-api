package com.tomio.recipe.image;

import com.tomio.recipe.Recipe;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class RecipeImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String recipeImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


    public RecipeImage() {}

    public RecipeImage(Integer id, String recipeImageUrl, Recipe recipe) {
        this.id = id;
        this.recipeImageUrl = recipeImageUrl;
        this.recipe = recipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipeImageUrl() {
        return recipeImageUrl;
    }

    public void setRecipeImageUrl(String recipeImageUrl) {
        this.recipeImageUrl = recipeImageUrl;
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
        if (!(o instanceof RecipeImage that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(recipeImageUrl, that.recipeImageUrl) && Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeImageUrl, recipe);
    }

    @Override
    public String toString() {
        return "RecipeImage{" +
                "id=" + id +
                ", recipeImageUrl='" + recipeImageUrl + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}
