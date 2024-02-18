import exception.CannotReadFileException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class PlayerIngredientReader {

    private PlayerIngredientReader() {}

    static List<String> getPlayerIngredients(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.lines().toList();
        } catch (IOException e) {
            throw new CannotReadFileException("Cannot read the players file!");
        }
    }
}
