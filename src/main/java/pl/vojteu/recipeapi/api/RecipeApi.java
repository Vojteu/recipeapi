package pl.vojteu.recipeapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.vojteu.recipeapi.dao.entity.Recipe;
import pl.vojteu.recipeapi.manager.RecipeManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeApi {
//    private List<Recipe> recipeList;

    private RecipeManager recipeList;

    @Autowired
    public RecipeApi(RecipeManager recipeList) {
        this.recipeList = recipeList;
    }

    @GetMapping("/all")
    public Iterable<Recipe> getAll() {
        return recipeList.findAll();
    }

    @GetMapping
    public Optional<Recipe> getById(@RequestParam Long index) {

        return recipeList.findById(index);
    }

    @PostMapping
    public Recipe addRecipe (@RequestBody Recipe recipe){
        return recipeList.save(recipe);
    }

    @PutMapping
    public Recipe updateRecipe (@RequestBody Recipe recipe){
        return recipeList.save(recipe);
    }

    @DeleteMapping
    public void deleteRecipe (@RequestParam Long index){
        recipeList.deleteById(index);
    }
}