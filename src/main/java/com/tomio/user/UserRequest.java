package com.tomio.user;

import com.tomio.recipe.Recipe;

import java.util.List;

public record UserRequest(Integer id, String username, String email, String password, List<Recipe> recipes) {
}
