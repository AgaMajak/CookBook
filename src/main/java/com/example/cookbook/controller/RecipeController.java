package com.example.cookbook.controller;

import com.example.cookbook.domain.Recipe;
import com.example.cookbook.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RecipeController {

   private final RecipeRepository recipeRepository;

   @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @GetMapping("/")
    @ResponseBody
    public List<Recipe> home() {
       return recipeRepository.findAll();
    }
}
