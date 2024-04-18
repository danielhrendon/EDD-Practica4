package newpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class lgBicola extends lgColaLista{
    // inicializa frente y fin a null
    public lgBicola() {
        super();
    }
    
    // inserta por el final de la Bicola
    public void ponerFinal(Object elemento) {
        insertar(elemento); // método heredado de ColaLista
    }
    
    // inserta por el frente; método propio de Bicola
    public void ponerFrente(Object elemento) {
        lgCLNodo a;
        a = new lgCLNodo(elemento);
        if (colaVacia()) {
            fin = a;
        }
        a.siguiente = frente;
        frente = a;
    }
    
    // retira elemento frente de la Bicola
    public Object quitarFrente() throws Exception {
        return quitar(); // método heredado de ColaLista
    }
    
    // retira elemento final; método propio de Bicola.
    // Es necesario recorrer la bicola para situarse en
    // el nodo anterior al final, para después enlazar.

    public Object quitarFinal() throws Exception {
        Object aux;
        if (!colaVacia()) {
            if (frente == fin) // la Bicola dispone de un solo nodo
            {
                aux = quitar();
            } else {
                lgCLNodo a = frente;
                while (a.siguiente != fin) {
                    a = a.siguiente;
                }
                // siguiente del nodo anterior se pone a null
                a.siguiente = null;
                aux = fin.elemento;
                fin = a;
            }
        } else {
            throw new Exception("Eliminar de una bicola vacía");
        }
        return aux;
    }

    public Object frenteBicola() throws Exception {
        return frenteCola(); // método heredado de ColaLista
    }
    
    // devuelve el elemento final
    public Object finalBicola() throws Exception {
        if (colaVacia()) {
            throw new Exception("Error: cola vacía");
        }
        return (fin.elemento);
    }
    
    // comprueba el estado de la bicola
    public boolean bicolaVacia() {
        return colaVacia(); // método heredado de ColaLista
    }

    //elimina la bicola
    public void borrarBicola() {
        borrarCola(); // método heredado de ColaLista
    }

    public int numElemsBicola() // cuenta los elementos de la bicola
    {
        int n;
        lgCLNodo a = frente;
        if (bicolaVacia()) {
            n = 0;
        } else {
            n = 1;
            while (a != fin) {
                n++;
                a = a.siguiente;
            }
        }
        return n;
    }
}
