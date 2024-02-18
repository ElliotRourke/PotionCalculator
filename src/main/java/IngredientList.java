import exception.CannotReadFileException;
import exception.InvalidFileException;
import model.Ingredient;
import model.IngredientType;
import model.Rarity;
import model.TraitStatus;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class IngredientList {
    private static final File INGREDIENT_LIST_RESOURCE = new File("ingredient_list.csv");
    private static final Collection<Ingredient> INGREDIENTS = new HashSet<>();

    private IngredientList() {}

    static Collection<Ingredient> getIngredients() {
        if (INGREDIENTS.isEmpty()) {
            INGREDIENTS.addAll(generateIngredientCollection());
        }
        return INGREDIENTS;
    }

    private static Collection<Ingredient> generateIngredientCollection() {
        try (BufferedReader br = new BufferedReader(new FileReader(INGREDIENT_LIST_RESOURCE))) {
            String header = br.lines()
                    .findFirst()
                    .orElse(null);
            if (isValidHeader(header)) {
                return br
                        .lines()
                        .skip(1)
                        .map(line -> line.split(","))
                        .map(IngredientList::mapToEnumMap)
                        .map(IngredientList::mapToIngredient)
                        .collect(Collectors.toSet());
            } else {
                throw new InvalidFileException("No header found in ingredient list file!");
            }
        } catch (IOException e) {
            throw new CannotReadFileException("Could not open ingredient list resource!");
        }
    }

    private static boolean isValidHeader(String header) {
        if (header == null || header.isEmpty() || header.isBlank()) {
            return false;
        }
        String[] headerArr = header.split(",");
        return headerArr.length == IngredientHeader.values().length;
    }

    private static Map<Enum<IngredientHeader>, String> mapToEnumMap(String[] arr) {
        Map<Enum<IngredientHeader>, String> map = new HashMap<>();
        for (String s : arr) {
            map.put(IngredientHeader.valueOf(s), s);
        }
        return map;
    }

    private static Ingredient mapToIngredient(Map<Enum<IngredientHeader>, String> map) {
        return new Ingredient.IngredientBuilder()
                .name(map.get(IngredientHeader.name))
                .cost(Integer.parseInt(map.get(IngredientHeader.cost)))
                .ingredientType(IngredientType.valueOf(map.get(IngredientHeader.ingredientType)))
                .rarity(Rarity.valueOf(map.get(IngredientHeader.rarity)))
                .aTypeAmount(Integer.parseInt(map.get(IngredientHeader.aTypeAmount)))
                .bTypeAmount(Integer.parseInt(map.get(IngredientHeader.bTypeAmount)))
                .cTypeAmount(Integer.parseInt(map.get(IngredientHeader.cTypeAmount)))
                .dTypeAmount(Integer.parseInt(map.get(IngredientHeader.dTypeAmount)))
                .eTypeAmount(Integer.parseInt(map.get(IngredientHeader.eTypeAmount)))
                .taste(TraitStatus.valueOf(map.get(IngredientHeader.taste)))
                .sensation(TraitStatus.valueOf(map.get(IngredientHeader.sensation)))
                .aroma(TraitStatus.valueOf(map.get(IngredientHeader.aroma)))
                .visual(TraitStatus.valueOf(map.get(IngredientHeader.visual)))
                .sound(TraitStatus.valueOf(map.get(IngredientHeader.sound)))
                .location(map.get(IngredientHeader.location))
                .build();
    }

}
