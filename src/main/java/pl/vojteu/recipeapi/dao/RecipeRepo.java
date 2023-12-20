package pl.vojteu.recipeapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.vojteu.recipeapi.dao.entity.Recipe;

@Repository
public interface RecipeRepo extends CrudRepository<Recipe,Long> {
}
