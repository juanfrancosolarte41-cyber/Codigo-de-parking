/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucompensar.codigo;

/**
 *
 * @author HP
 */
public class Pila {
    private Nodo cima;

    public boolean estaVacia() {
        return cima == null;
    }
    
    public void apilar(String placa) {
        Nodo nuevo = new Nodo(placa);
        nuevo.siguiente = cima;
        cima = nuevo;
    }
    
    public String desapilar() {
        if (estaVacia()) {
            return null;
        }
        String placa = cima.placa;
        cima = cima.siguiente;
        return placa;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("No hay salidas registradas.");
            return;
        }
        Nodo actual = cima;
        while (actual != null) {
            System.out.println("Placa: " + actual.placa);
            actual = actual.siguiente;
        }
    }
}