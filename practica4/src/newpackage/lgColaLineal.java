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

public class lgColaLineal {
    static final int MAXTAMQ = 39;
    public int frente;
    public int fin;
    public String[] listaCola;
    public int maxTamaño;

    private lgColaLineal(int maxTamaño) {
        frente = 0;
        fin = -1;
        listaCola = new String[maxTamaño];
        this.maxTamaño = maxTamaño;
    }

    lgColaLineal() {
        this(MAXTAMQ);
    }

    // operaciones de modificación de la cola
    public void insertar(String elemento) throws Exception {
        if (!colaLlena()) {
            listaCola[++fin] = elemento;
        } else {
            throw new Exception("Overflow en la cola");
        }
}

    public String quitar() throws Exception {
        if (!colaVacia()) {
            return listaCola[frente++];
        } else {
            throw new Exception("Cola vacia ");
        }
    }

    // vacía la cola
    public void borrarCola() {
        frente = 0;
        fin = -1;
    }

    // acceso a la cola
    public String frenteCola() throws Exception {
        if (!colaVacia()) {
            return listaCola[frente];
        } else {
            throw new Exception("Cola vacia ");
        }
    }

    // métodos de verificación del estado de la cola
    public boolean colaVacia() {
        return frente > fin;
    }

    public boolean colaLlena() {
        return fin == maxTamaño - 2;
    }
    
    public void actualizarTamaño(int nuevoTamaño) {
    // Crear una nueva lista temporal con el nuevo tamaño
    String[] nuevaListaCola = new String[nuevoTamaño];

    // Copiar los elementos existentes a la nueva lista
    int elementosCopiados = Math.min(maxTamaño, nuevoTamaño);
    for (int i = 0; i < elementosCopiados; i++) {
        nuevaListaCola[i] = listaCola[i];
    }

    // Actualizar la lista y el tamaño máximo
    listaCola = nuevaListaCola;
    maxTamaño = nuevoTamaño;

    // Ajustar frente y fin si es necesario
    fin = Math.min(fin, maxTamaño - 1);
}
}