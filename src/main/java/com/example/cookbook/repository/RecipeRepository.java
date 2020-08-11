package com.example.cookbook.repository;

import com.example.cookbook.domain.Category;
import com.example.cookbook.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByCategory(Category category);

    @Transactional
    void deleteByName(String name);

    Recipe findByName(String name);

    List<Recipe> findAllByOrderByLikeCounterDesc();

}