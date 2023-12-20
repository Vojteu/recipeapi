package pl.vojteu.recipeapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.vojteu.recipeapi.dao.RecipeRepo;
import pl.vojteu.recipeapi.dao.entity.Recipe;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class RecipeManager {
    private RecipeRepo recipeRepo;

    @Autowired
    public RecipeManager(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    public Optional<Recipe> findById(Long id){
        return recipeRepo.findById(id);
    }

    public Iterable<Recipe> findAll(){
        return recipeRepo.findAll();
    }
    public Recipe save(Recipe recipe){
        return recipeRepo.save(recipe);
    }

    public void deleteById(Long id){
        recipeRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Recipe(1L, "Kotlet Schabowy Wojtasa", LocalDate.of(2021,12,27)));
        save(new Recipe(2L, "Mielone Wojtasa", LocalDate.of(2021,12,27)));
        save(new Recipe(3L, "Burger Wojtasa", LocalDate.of(2021,12,27)));
    }
}
