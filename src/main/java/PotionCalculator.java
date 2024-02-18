import model.Ingredient;

import java.util.Collection;
import java.util.List;

public class PotionCalculator {

    /*
        Args:
            1. Player Ingredient List
            2. Desired Potion(s?)
            3. Option to see what the *best* recipes for a potion (can exclude arg 1)
     */
    public static void main (String[] args) {
        //TODO: Validate Args!

        final Collection<Ingredient> ingredients = IngredientList.getIngredients();
        final List<String> playerIngredients = PlayerIngredientReader.getPlayerIngredients(args[0]);

    }
}
