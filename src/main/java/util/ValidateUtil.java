package util;

public class ValidateUtil {

    public static boolean isEmpty(String texto) {
        return texto == null || texto.isEmpty() || texto.isBlank();
    }

}
