import exception.CannotReadFileException;
import exception.InvalidFileException;
import model.Potion;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

class PotionList {
    private static final File POTION_LIST_RESOURCE = new File("potion_list.csv");
    private static final Collection<Potion> POTIONS = new HashSet<>();

    private PotionList() {}

    static Collection<Potion> getPotions() {
        if (POTIONS.isEmpty()) {
            POTIONS.addAll(generatePotionCollection);
        }
        return POTIONS;
    }

    private static Collection<Potion> generatePotionCollection() {
        try (BufferedReader br = new BufferedReader(new FileReader(POTION_LIST_RESOURCE))) {
            String header = br.lines()
                    .findFirst()
                    .orElse(null);
            if (isValidHeader(header)) {
                return br
                        .lines()
                        .skip(1)
                        .map(line -> line.split(","))
                        .map(PotionList::mapToEnumMap)
                        .map(PotionList::mapToIngredient)
                        .collect(Collectors.toSet());
            } else {
                throw new InvalidFileException("No header found in potion list file!");
            }
        } catch (IOException e) {
            throw new CannotReadFileException("Could not read potion list resource");
        }
    }

    private static boolean isValidHeader(String header) {
        if (header == null || header.isEmpty() || header.isBlank()) {
            return false;
        }
        String[] headerArr = header.split(",");
        return headerArr.length == IngredientHeader; //TODO: what headers do I need?
    }
}
