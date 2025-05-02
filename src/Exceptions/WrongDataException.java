package Exceptions;

public class WrongDataException extends RuntimeException{
    public WrongDataException() {
        super("Неверный формат данных");
    }
}
