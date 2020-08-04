package com.example.cookbook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "VARCHAR(100)")
    private String imgUrl;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(columnDefinition = "VARCHAR(10000)")
    private String description;

    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
        ingredient.setRecipe(this);
    }

}
