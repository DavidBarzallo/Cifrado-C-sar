import java.nio.file.Paths;
import java.util.Scanner;

public class Menu {

//    private static String relativePath;

    /**
     * Este método muestra el menú inicial y permite el acceso a las diferentes opciones a traves del scanner.
     *
     * */
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();

        boolean exit = false;

        while (!exit) {
            printMenu();

            int option = getUserInput(scanner, "Seleccione una opción (0-2): ");
            switch (option) {
                case 1:
                    metodoEncryption(scanner, fileManager);
                    break;
                case 2:
                    metodoDecryption(scanner, fileManager);
                    break;
                case 0:
                    System.out.println("--------------------------- ");
                    System.out.println("Exiting program...");
                    System.out.println("--------------------------- ");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("--------------------------- ");
                    System.out.println("Opcion inválida, Try again.");
                    System.out.println("--------------------------- ");
            }

            exit = false;
        }
    }

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Encryption");
        System.out.println("2. Decryption with key");
        System.out.println("0. Exit");
        System.out.println("---------------------------");
    }

    private static int getUserInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Este método muestra las opciones de texto a encriptar y se escogen a traves del scanner.
     *
     * */
    private static void metodoEncryption(Scanner scanner, FileManager fileManager) {
        System.out.println("--------------------------- ");
        System.out.println("Escogió: Encryption ");
        System.out.println("--------------------------- ");

        System.out.println("Escoge un archivo para encriptar:");
        System.out.println("1. texto1.txt");
        System.out.println("2. texto2.txt");
        System.out.print("Escoge 1 o 2: ");
        int opcionArchivo = scanner.nextInt();

        String inputFile = (opcionArchivo == 1) ? "files/texto1.txt" : "files/texto2.txt";

        int desplazamiento = getUserInput(scanner, "Introduce el número de desplazamiento: ");
        try {
            String ruta = getFilePath(inputFile);
            String outputPath = getFilePath("files/texto_cifrado.txt");
            String content = fileManager.leerArchivo(ruta);

            if (content == null || content.isEmpty()) {
                System.out.println("El archivo de entrada está vacío o no se pudo leer.");
                return;
            }

            String textoEncriptado = Cipher.cifrarTexto(content, desplazamiento);
            Cipher.guardarArchivo(textoEncriptado, outputPath);

            System.out.println("Archivo cifrado guardado en: " + outputPath);
        } catch (Exception e) {
            System.err.println("Error durante el proceso de encriptación: " + e.getMessage());
        }
    }


    /**
     * Este método recoge el valor de desplazamiento a traves del scanner y lo usa como parámetro para la clase Cipher.
     *
     * */
    private static void metodoDecryption(Scanner scanner, FileManager fileManager) {
        System.out.println("--------------------------- ");
        System.out.println("Escogió: Decryption with key ");
        System.out.println("--------------------------- ");

        int desplazamiento = getUserInput(scanner, "Introduce la clave de desplazamiento: ");
        try {
            String inputPath = getFilePath("files/texto_cifrado.txt");
            String outputPath = getFilePath("files/texto_descifrado.txt");
            String content = fileManager.leerArchivo(inputPath);

            if (content == null || content.isEmpty()) {
                System.out.println("El archivo cifrado está vacío o no se pudo leer.");
                return;
            }

            String decryptedText = Cipher.descifrarTexto(content, desplazamiento);
            Cipher.guardarArchivo(decryptedText, outputPath);

            System.out.println("Archivo descifrado guardado en: " + outputPath);
        } catch (Exception e) {
            System.err.println("Error durante el proceso de desencriptación: " + e.getMessage());
        }
    }

    private static String getFilePath(String relativePath) {
        return Paths.get(System.getProperty("user.dir"), relativePath).toString();
    }

}
