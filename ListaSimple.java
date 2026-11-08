
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.ucompensar.codigo;
/**
 *
 * @author NicolasAlejandroPerezRamirez
 */
public class ListaSimple {

    Nodo cabeza;

    public ListaSimple() {
        cabeza = null;
    }

    public void agregar(String placa) {
        Nodo nuevo = new Nodo(placa);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }
    }

    public void mostrar() {
        Nodo actual = cabeza;

        if (actual == null) {
            System.out.println("No hay vehiculos registrados.");
        } else {
            while (actual != null) {
                System.out.println("Placa: " + actual.placa);
                actual = actual.siguiente;
            }
        }
    }

    public boolean buscar(String placa) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.placa.equals(placa)) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public boolean eliminar(String placa) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.placa.equals(placa)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.siguiente.placa.equals(placa)) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }
}

