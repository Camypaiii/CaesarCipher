import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class WordDelimetr {

    public static Set<String> wordDelimetr(String nameFile) {

        String input = null;
        try {
            input = Files.readString(Path.of(nameFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringTokenizer tokenizer = new StringTokenizer(input, "\r ,.!?:;()\n");
        String[] arrayWordsTest = new String[tokenizer.countTokens()];
        int ind = 0;
        while (tokenizer.hasMoreTokens()) {
            arrayWordsTest[ind++] = tokenizer.nextToken().toLowerCase();
        }
        Set<String> setWords = new HashSet<>(List.of(arrayWordsTest));
        return setWords;
    }
}
