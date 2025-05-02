package Exceptions;

public class NoFileException extends RuntimeException{
    public NoFileException(String fileName) {
        super("Файл " + fileName + " не найден!");
    }
}
