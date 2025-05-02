import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Cripto {

    private final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public char[] getALPHABET() {
        return ALPHABET;
    }

    public void encrypt(String inputFile, String outputFile, int key) {
        List<String> allLinesIn = FileManager.readFile(inputFile);
        List<String> allLinesOut = new ArrayList<>();

        for (String str : allLinesIn) {
            String text = str.toLowerCase();
            char[] arrayText = text.toCharArray();

            for (int i = 0; i < arrayText.length; i++) {
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (arrayText[i] == ALPHABET[j]) {
                        if (j + key >= ALPHABET.length) {
                            arrayText[i] = ALPHABET[(j + key) % ALPHABET.length];
                            break;
                        } else {
                            arrayText[i] = ALPHABET[j + key];
                            break;
                        }
                    }
                }
            }
            allLinesOut.add(new String(arrayText));
        }
        FileManager.writeFile(allLinesOut, outputFile);
    }

    public void decrypt(String inputFile, String outputFile, int key) {
        try (FileReader input = new FileReader(inputFile);
             BufferedReader reader = new BufferedReader(input);
             FileWriter output = new FileWriter(outputFile);
             BufferedWriter writer = new BufferedWriter(output)) {

            while (reader.ready()) {
                String text = reader.readLine().toLowerCase();
                char[] arrayText = text.toCharArray();

                for (int i = 0; i < arrayText.length; i++) {
                    for (int j = 0; j < ALPHABET.length; j++) {
                        if (arrayText[i] == ALPHABET[j]) {
                            if (j - key < 0) {
                                arrayText[i] = ALPHABET[ALPHABET.length + (j - key)];
                                break;
                            } else {
                                arrayText[i] = ALPHABET[j - key];
                                break;
                            }
                        }
                    }
                }
                writer.write(arrayText);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void bruteForce(String inputFile, String outputFile, String testFile) {

        Set<String> setWords = WordDelimetr.wordDelimetr(testFile);


        for (int i = 1; i < ALPHABET.length - 1; i++) {
            decrypt(inputFile, i + outputFile, i);
            Set<String> temp = WordDelimetr.wordDelimetr(i + outputFile);
            int count = 0;

            for (String str : temp) {
                if (str.length() >= 2) {
                    if (setWords.contains(str)) {
                        count++;
                        if (count == 3) break;
                    }
                }
            }
            try {
                if (count < 3) {
                    Files.delete(Path.of(i + outputFile));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }

}
