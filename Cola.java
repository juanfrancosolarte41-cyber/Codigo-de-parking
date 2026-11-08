/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucompensar.codigo;

/**
 *
 * @author S
 */
public class Cola {
    private Nodo frente;
    private Nodo fin;

    public boolean estaVacia() {
        return frente == null;
    }
    
    public void encolar(String placa) {
        Nodo nuevo = new Nodo(placa);
        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }
    
    public String desencolar() {
        if (estaVacia()) {
            return null;
        }
        String placa = frente.placa;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return placa;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("No hay vehiculos en espera.");
            return;
        }
        Nodo actual = frente;
        int turno = 1;
        while (actual != null) {
            System.out.println("Turno " + turno + " - Placa: " + actual.placa);
            actual = actual.siguiente;
            turno++;
        }
    }
}