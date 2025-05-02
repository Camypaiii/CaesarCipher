import java.util.Scanner;

public class CaesarCipherApp {
    public static void main(String[] args) {

        Cripto cipher = new Cripto();

        Scanner cons = new Scanner(System.in);
        String input;
        String cryptFile;
        String decryptFile;
        String testFile;
        int key;

        while (true) {
            System.out.println("""
                    Выберите один из следующих пунктов меню:
                    1 - Зашифровать файл.
                    2 - Расшифровать файл.
                    3 - Взломать файл.
                    4 - Выход.
                    """);
            String numMenu = cons.nextLine();
            switch (numMenu) {
                case "1" -> {
                    System.out.println("Введите имя(путь) исходного файла:");
                    input = cons.nextLine();
                    Validator.validFileName(input);
                    Validator.exsistsFile(input);
                    System.out.println("Введите имя(путь) зашифрованного файла:");
                    cryptFile = cons.nextLine();
                    Validator.validFileName(cryptFile);
                    System.out.println("Введите key - целое число от 1 до " + (cipher.getALPHABET().length - 1));
                    key = Integer.parseInt(cons.nextLine());
                    Validator.isValidKey(key, cipher.getALPHABET());
                    cipher.encrypt(input, cryptFile, key);
                    return;
                }
                case "2" -> {
                    System.out.println("Введите имя(путь) зашифрованного файла:");
                    cryptFile = cons.nextLine();
                    Validator.validFileName(cryptFile);
                    Validator.exsistsFile(cryptFile);
                    System.out.println("Введите имя(путь) расшифрованного файла:");
                    decryptFile = cons.nextLine();
                    Validator.validFileName(decryptFile);
                    System.out.println("Введите key - целое число от 0 до " + (cipher.getALPHABET().length - 1));
                    key = Integer.parseInt(cons.nextLine());
                    Validator.isValidKey(key, cipher.getALPHABET());
                    cipher.decrypt(cryptFile, decryptFile, key);
                    return;
                }
                case "3" -> {
                    System.out.println("Введите имя(путь) зашифрованного файла:");
                    cryptFile = cons.nextLine();
                    Validator.validFileName(cryptFile);
                    Validator.exsistsFile(cryptFile);
                    System.out.println("Введите имя(путь) расшифрованного файла:");
                    decryptFile = cons.nextLine();
                    Validator.validFileName(decryptFile);
                    System.out.println("Введите имя(путь) тестового файла:");
                    testFile = cons.nextLine();
                    Validator.validFileName(testFile);
                    Validator.exsistsFile(testFile);
                    cipher.bruteForce(cryptFile, decryptFile, testFile);
                    return;
                }

                case "4" -> {
                    return;
                }
                default -> System.out.println("Неверный ввод. Пожалуйста, выберите 1, 2, 3 или 4");
            }

            cons.close();
        }


    }
}
