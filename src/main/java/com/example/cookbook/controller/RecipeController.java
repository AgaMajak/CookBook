package com.example.cookbook.controller;

import com.example.cookbook.domain.Category;
import com.example.cookbook.domain.Recipe;
import com.example.cookbook.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RecipeController {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(name = "sortuj", required = false) String sorted) {
        if (sorted != null) {
            List<Recipe> recipes = recipeRepository.findAllByOrderByLikeCounterDesc();
            model.addAttribute("recipes", recipes);
        } else {
            List<Recipe> recipes = recipeRepository.findAll();
            model.addAttribute("recipes", recipes);
        }
        return "home";
    }

    @GetMapping("/przepis")
    public String recipeDetails(Model model, @RequestParam(name = "nazwa") String name) {

        Recipe recipe = recipeRepository.findByName(name);

        if (recipe != null) {
            model.addAttribute("recipe", recipe);
            return "recipe";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/usuń")
    public String deleteRecipe(Model model, @RequestParam(name = "nazwa") String name) {
        if (name != null) {
            recipeRepository.deleteByName(name);
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/kategoria")
    public String recipeByCategory(Model model, @RequestParam Category category) {
        if (category != null) {
            List<Recipe> recipes = recipeRepository.findByCategory(category);
            model.addAttribute("category", category);
            model.addAttribute("recipes", recipes);
            return "category";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/like")
    public String likeRecipe(@RequestParam(name = "nazwa") String name) {
        Recipe recipe = recipeRepository.findByName(name);
        recipe.setLikeCounter(recipe.getLikeCounter() + 1);
        recipeRepository.save(recipe);
        return "redirect:/przepis?nazwa=" + name;
    }

    @GetMapping("/dodaj")
    public String getRecipeInfo(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "add";
    }

    @PostMapping("/dodaj")
    public String addNewRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/";
    }

    @GetMapping("/edytuj")
    public String editRecipe(Model model, @RequestParam(name = "nazwa") String name) {
        Recipe recipe = recipeRepository.findByName(name);
        model.addAttribute("recipe", recipe);
        return "edit";
    }

    @PostMapping("/edytuj")
    public String updateRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/";
    }
}