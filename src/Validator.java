import Exceptions.InvalidKeyException;
import Exceptions.NoFileException;
import Exceptions.WrongDataException;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    public static void isValidKey(int key, char[] alphabet) {
        if (key <= 0 && key >= alphabet.length) {
            throw new InvalidKeyException();
        }

    }

    public static void validFileName(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new WrongDataException();
        }
    }

    public static void exsistsFile(String filePath) {
        if (Files.notExists(Path.of(filePath))) {
            throw new NoFileException(filePath);
        }
    }

}
