package exa_2_edd;

import static exa_2_edd.Arbol.out;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class EXA_2_EDD {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Arbol raiz = null;
        char opcion;
        String cadena, linea;
        Scanner teclado;
        if (System.getProperties().get("os.name").equals("Linux") || System.console() == null) {
            teclado = new Scanner(System.in);
            out = System.out;
        } else {
            teclado = new Scanner(System.in, "CP850");
            out = new PrintStream(System.out, true, "CP850");
        }
        do {
            out.print(
                    "MENÚ\n"
                    + "1.- Insertar cadena\n"
                    + "2.- Quitar cadena\n"
                    + "3.- Listado en preorden\n"
                    + "4.- Listado en inorden\n"
                    + "5.- Listado en postorden\n"
                    + "6.- Salir\n\n"
                    + "Seleccione una opción: ");
            do {
                linea = teclado.nextLine();
            } while (linea.length() != 1 || linea.charAt(0) < '1' || linea.charAt(0) > '6');
            opcion = linea.charAt(0);
            out.println();
            if (raiz == null && opcion != '1' && opcion != '6') {
                out.println("El árbol está vacío.");
            } else {
                switch (opcion) {
                    case '1':
                        out.print("Ingrese el cadena a insertar: ");
                        cadena = teclado.nextLine();
                        raiz = Arbol.insertar(raiz, cadena);
                        out.println("\nCadena agregada correctamente.");
                        break;
                    case '2':
                        out.print("Ingrese el cadena a quitar: ");
                        cadena = teclado.nextLine();
                        raiz = Arbol.quitar(raiz, cadena);
                        out.println("\nCadena borrada correctamente.");
                        break;
                    case '3':
                        Arbol.preorden(raiz);
                        break;
                    case '4':
                        Arbol.inorden(raiz);
                        break;
                    case '5':
                        Arbol.postorden(raiz);
                        break;
                }
            }
            if (opcion == '6') {
                out.print("\nPresione <ENTER> para continuar . . . ");
                teclado.nextLine();
                out.println("\n\n\n\n\n\n\n\n");
            }
        } while (opcion != '6');
    }
}
