package exa_2_edd;

import java.io.PrintStream;

public class Arbol {
    private Arbol izq = null, der = null;
    private String cadena;

    public static PrintStream out;

    private Arbol() {}
   
    private Arbol(String cadena) {
        this.cadena = cadena;
    }

    public static Arbol insertar(Arbol nodo, String cadena) {
        if (nodo == null)
            nodo = new Arbol(cadena);
        else if (cadena.compareTo(nodo.cadena) < 0)
            nodo.izq = insertar(nodo.izq, cadena);
        else if(cadena.compareTo(nodo.cadena) > 0){
            nodo.der = insertar(nodo.der, cadena);
        }else{
            System.out.println("ELEMENTO REPETIDO!");
        }
        return nodo;
    }

    public static Arbol quitar(Arbol nodo, String cadena) {
        if (nodo != null) {
            if (cadena.equals(nodo.cadena)) {
                Arbol pivote;
                if (nodo.izq == null)
                    pivote = nodo.der;
                else if (nodo.der == null)
                    pivote = nodo.izq;
                else {
                    for (pivote = nodo.izq; pivote.der != null; pivote = pivote.der);
                    pivote.der = nodo.der;
                    pivote = nodo.izq;
                }
                nodo = pivote;
            } else if (cadena.compareTo(nodo.cadena) < 0)
                nodo.izq = quitar(nodo.izq, cadena);
            else
                nodo.der = quitar(nodo.der, cadena);
        }
        return nodo;
    }

    public static void preorden(Arbol nodo) {
        if (nodo != null) {
            out.println(nodo.cadena);
            preorden(nodo.izq);
            preorden(nodo.der);
        }
    }

    public static void inorden(Arbol nodo) {
        if (nodo != null) {
            inorden(nodo.izq);
            out.println(nodo.cadena);
            inorden(nodo.der);
        }
    }

    public static void postorden(Arbol nodo) {
        if (nodo != null) {
            postorden(nodo.izq);
            postorden(nodo.der);
            out.println(nodo.cadena);
        }
    }
}
