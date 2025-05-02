package Exceptions;

public class InvalidKeyException extends RuntimeException{
    public InvalidKeyException() {
        super("Неверный диапазон значений ключа");
    }
}
