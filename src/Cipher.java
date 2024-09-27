public class Cipher {

    private static String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!?%$@&*(){};:'\".,></#-+=- ";

    // desplazar alfabeto
    public static String desplazarAlfabeto(int posicion, boolean haciaDerecha) {
        int longitud = alfabeto.length();
        // sacar resto de división
        posicion = posicion % longitud;

        // desplazamiento  hacia la izquierda,
        if (!haciaDerecha) {
            posicion = longitud - posicion;
        }

        // Desplazar el alfabeto
        String alfabetoDesplazado = alfabeto.substring(posicion) + alfabeto.substring(0, posicion);

        // Reemplazar el alfabeto original por el desplazado
        alfabeto = alfabetoDesplazado;

        return alfabeto;
    }

    public static void main(String[] args) {
        // Mostrar el alfabeto original

        System.out.println();
        System.out.println("Alfabeto original | " + alfabeto.length() + " caracteres:\n" + alfabeto);
        System.out.println();

        // Desplazar hacia la derecha
        String nuevoAlfabeto = desplazarAlfabeto(7, true);
        System.out.println("Alfabeto desplazado | " + alfabeto.length() + " caracteres:\n" + nuevoAlfabeto);

        // Desplazar hacia la izquierda
//        nuevoAlfabeto = desplazarAlfabeto(15, false);
//        System.out.println("Alfabeto desplazado 2 posiciones hacia la izquierda: " + nuevoAlfabeto);
    }
}


