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
public class lgColaCircular {
    static final int MAXTAMQ = 99;
    public int frente;
    public int fin;
    public Object[] listaCola;
    public int maxTamaño; // Nuevo campo para almacenar el tamaño máximo
    
    // avanza una posición
    private int siguiente(int r) {
        return (r + 1) % maxTamaño;
    }
    
    // Constructor que toma el tamaño máximo como argumento
    public lgColaCircular(int maxTamaño) {
        this.maxTamaño = maxTamaño;
        frente = 0;
        fin = maxTamaño - 1;
        listaCola = new Object[maxTamaño];
    }
    
    // Constructor sin argumentos que utiliza un tamaño máximo predeterminado
    public lgColaCircular() {
        this(MAXTAMQ); // Llama al constructor con argumentos usando el tamaño predeterminado
    }
    // operaciones de modificación de la cola
    public void insertar(Object elemento) throws Exception {
        if (!colaLlena()) {
            fin = siguiente(fin);
            listaCola[fin] = elemento;
        } else {
            throw new Exception("Overflow en la cola");
        }
    }

    public Object quitar() throws Exception {
        if (!colaVacia()) {
            Object tm = listaCola[frente];
            frente = siguiente(frente);
            return tm;
        } else {
            throw new Exception("Cola vacia ");
        }
    }

    public void borrarCola() {
        frente = 0;
        fin = maxTamaño - 1;
    }
    
    // acceso a la cola
    public Object frenteCola() throws Exception {
        if (!colaVacia()) {
            return listaCola[frente];
        } else {
            throw new Exception("Cola vacia ");
        }
    }
    
    // métodos de verificación del estado de la cola
    public boolean colaVacia() {
        return frente == siguiente(fin);
    }
    
    // comprueba si está llena
    public boolean colaLlena() {
        return frente == siguiente(siguiente(fin));
    }
}
