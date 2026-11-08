
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucompensar.codigo;

import java.util.Scanner;

/**
 *
 * @author NicolasAlejandroPerezRamirez
 */
public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Cadena de las placas de los vehiculos que estan registrados ya
        String[] placas = {"ACR132", "XYZ122", "ERZ211", "LOP099", "VUU221"};
        ListaSimple listaVehiculos = new ListaSimple();
        Cola colaEspera = new Cola();
        Pila historialSalidas = new Pila();

        for (int i = 0; i < placas.length; i++) {
            listaVehiculos.agregar(placas[i]);
        }

        //Matriz de los puestos ocupados (O) y los libres(L)
        String[][] mapaParqueadero = {
            {" [O] ", " [O] ", " [O] ", " [L] "},
            {" [O] ", " [O] ", " [L] ", " [L] "},
            {" [L] ", " [L] ", " [L] ", " [L] "}
        };

        int opcion = 0;

        do {
            try {
                System.out.println("\nMENU SISTEMA DE PARQUEADERO");
                System.out.println("1. Mostrar vehiculos registrados");
                System.out.println("2. Ordenar vehiculos por placa mediante burbuja");
                System.out.println("3. Ordenar vehiculos por placa mediante seleccion");
                System.out.println("4. Buscar vehiculo mediante busqueda secuencial");
                System.out.println("5. Buscar vehiculo mediante busqueda binaria (Debe de estar ordenado el array)");
                System.out.println("6. Mostrar ocupacion de parqueadero");
                System.out.println("7. Mostrar vehiculos mediante lista simple");
                System.out.println("8. Buscar vehiculo en lista simple");
                System.out.println("9. Eliminar vehiculo de lista simple");
                System.out.println("10. Agregar vehiculo a la cola de espera");
                System.out.println("11. Atender siguiente vehiculo de la cola");
                System.out.println("12. Mostrar cola de espera");
                System.out.println("13. Registrar salida de vehiculo");
                System.out.println("14. Deshacer ultima salida");
                System.out.println("15. Mostrar historial de salidas");

                System.out.println("0. Salir");
                System.out.println("\nIngrese una opcion");

                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nLista de viculos registrados:");

                        for (int i = 0; i < placas.length; i++) {
                            System.out.println("Vehiculo: " + (i + 1) + " - Placa: " + placas[i]);
                        }
                        break;

                    case 2:
                        System.out.println("\nVehiculos ordenados mediante burbuja");
                        for (int i = 0; i < placas.length - 1; i++) {
                            for (int j = 0; j < placas.length - 1 - i; j++) {
                                if (placas[j].compareTo(placas[j + 1]) > 0) {
                                    String auxiliar = placas[j];
                                    placas[j] = placas[j + 1];
                                    placas[j + 1] = auxiliar;
                                }
                            }
                        }
                        for (String placa : placas) {
                            System.out.println(placa);
                        }
                        break;

                    case 3:
                        System.out.println("\nVehiculos ordenados mediante seleccion");
                        for (int i = 0; i < placas.length - 1; i++) {
                            int placaMen = i;
                            for (int j = i + 1; j < placas.length; j++) {
                                if (placas[j].compareTo(placas[placaMen]) < 0) {
                                    placaMen = j;
                                }
                            }
                            String temp = placas[placaMen];
                            placas[placaMen] = placas[i];
                            placas[i] = temp;
                        }
                        for (String placa : placas) {
                            System.out.println(placa);
                        }
                        break;

                    case 4:
                        teclado.nextLine();
                        System.out.println("\nBusqueda de un vehiculo mediante busqueda secuencial");
                        System.out.println("Ingrese una placa para buscar ");
                        String buscarSecuencial = teclado.nextLine();

                        int pos = -1;

                        for (int i = 0; i < placas.length; i++) {
                            if (buscarSecuencial.equals(placas[i])) {
                                pos = i;
                                break;
                            }
                        }

                        if (pos != -1) {
                            System.out.println("La placa esta en la posicion: " + pos);
                        } else {
                            System.out.println("La placa no esta registrada");
                        }
                        break;

                    case 5:
                        teclado.nextLine();
                        System.out.println("\nBusqueda de un vehiculo mediante busqueda binaria");
                        System.out.println("Ingrese una placa para buscar ");
                        System.out.println("(Asegurese de ya haber ordenado o no funcionara)");

                        String placaBusBin = teclado.nextLine();

                        int inicio = 0;
                        int fin = placas.length - 1;
                        boolean encontrado = false;

                        while (inicio <= fin) {
                            int medio = (inicio + fin) / 2;

                            if (placas[medio].equals(placaBusBin)) {
                                System.out.println("Placa encontrada en la posición: " + medio);
                                encontrado = true;
                                break;
                            } else if (placas[medio].compareTo(placaBusBin) < 0) {
                                inicio = medio + 1;
                            } else {
                                fin = medio - 1;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("La placa no esta registrada");
                        }
                        break;

                    case 6:
                        System.out.println("\nMAPA DE ESPACIOS DEL PARQUEADERO");
                        System.out.println("[O] = Ocupado | [L] = Libre\n");
                        for (int i = 0; i < mapaParqueadero.length; i++) {
                            System.out.print("Piso/Fila " + (i + 1) + ":\t");
                            for (int j = 0; j < mapaParqueadero[i].length; j++) {
                                System.out.print(mapaParqueadero[i][j] + " ");
                            }
                            System.out.println();
                        }
                        break;
                    case 7:
                        System.out.println("\nLos vehiculos registrados en la lista simple");
                        listaVehiculos.mostrar();
                        break;

                    case 8:
                        teclado.nextLine();

                        System.out.println("\nBuasca  el vehiculo en la lista limple");
                        System.out.println("Ingrese la placa que desea buscar:");
                        String placaBuscar = teclado.nextLine();

                        if (listaVehiculos.buscar(placaBuscar)) {
                            System.out.println("El vehiculo se encuentra registrado.");
                        } else {
                            System.out.println("El vehiculo no esta registrado");
                        }
                        break;

                    case 9:
                        teclado.nextLine();

                        System.out.println("\nElimina el vehiculo de la lista simple");
                        System.out.println("Ingrese la placa que desea eliminar:");
                        String placaEliminar = teclado.nextLine();

                        if (listaVehiculos.eliminar(placaEliminar)) {
                            System.out.println("Vehiculo eliminado correctamente");
                        } else {
                            System.out.println("El vehiculo no esta registrado");
                        }
                        break;
                    case 10:
                        teclado.nextLine();
                        System.out.println("\nAgrega el vehiculo a la cola de espera");
                        System.out.println("Ingrese la placa:");
                        String placaEspera = teclado.nextLine();
                        colaEspera.encolar(placaEspera);
                        System.out.println("Vehiculo agregado a la cola de espera");
                        break;

                    case 11:
                        if (colaEspera.estaVacia()) {
                            System.out.println("\nNo hay vehiculos esperando");
                            break;
                        }
                        
                        boolean asignado = false;
                        for (int i = 0; i < mapaParqueadero.length && !asignado; i++) {
                            for (int j = 0; j < mapaParqueadero[i].length && !asignado; j++) {
                                if (mapaParqueadero[i][j].equals(" [L] ")) {
                                    String placaAtendida = colaEspera.desencolar();
                                    mapaParqueadero[i][j] = " [O] ";
                                    listaVehiculos.agregar(placaAtendida);
                                    System.out.println("\nVehiculo " + placaAtendida
                                            + " asignado al Piso/Fila " + (i + 1) + ", puesto " + (j + 1));
                                    asignado = true;
                                }
                            }
                        }
                        if (!asignado) {
                            System.out.println("\nNo hay puestos libres, el vehiculo sigue en espera");
                        }
                        break;

                    case 12:
                        System.out.println("\nLos vehiculos esta en la cola de espera");
                        colaEspera.mostrar();
                        break;

                    case 13:
                        teclado.nextLine();
                        System.out.println("\nRegistra salida del vehiculo");
                        System.out.println("Ingrese la placa que sale:");
                        String placaSalida = teclado.nextLine();

                        if (listaVehiculos.eliminar(placaSalida)) {
                            historialSalidas.apilar(placaSalida);
                            System.out.println("Salida registrada correctamente");
                        } else {
                            System.out.println("El vehiculo no esta registrado");
                        }
                        break;

                    case 14:
                        String placaDeshacer = historialSalidas.desapilar();
                        if (placaDeshacer == null) {
                            System.out.println("\nNo hay salidas para deshacer");
                        } else {
                            listaVehiculos.agregar(placaDeshacer);
                            System.out.println("\nSe deshizo la salida del vehiculo " + placaDeshacer);
                        }
                        break;

                    case 15:
                        System.out.println("\nHistorial de la salida (la ultima primero)");
                        historialSalidas.mostrar();
                        break;

                    case 0:
                        System.out.println("Saliendo del programa.");
                        break;

                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (Exception e) {
                System.out.println("\nPor favor, ingrese un numero valido y no letras o simbolos.");
                teclado.nextLine();
                opcion = 0;
            }

        } while (opcion != 0);

        teclado.close();
    }
}
