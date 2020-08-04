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

    @Column(columnDefinition = "VARCHAR(150)")
    private String imgUrl;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(columnDefinition = "VARCHAR(10000)")
    private String description;

    private int likeCounter;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.REMOVE)
    private List<Ingredient> ingredients = new ArrayList<>();
}