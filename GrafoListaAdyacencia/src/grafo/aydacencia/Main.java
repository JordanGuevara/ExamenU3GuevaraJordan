package grafo.aydacencia;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        boolean si = true;
        GrafoAdcia grafo = new GrafoAdcia(20);
        int num = 0, opc = 0;

        while (si) {
            System.out.println("1. Ingrese vertice.");
            System.out.println("2. Ingrese origen, destino y peso.");
            System.out.println("3. Mostrar.");
            System.out.println("4. Salir.");
            System.out.print("Seleccionar: ");
            opc = tc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Ingrese el numero de ciudades a ingresar: ");
                    num = tc.nextInt();
                    try {
                        for (int i = 1; i <= num; i++) {
                            System.out.println("Ingrese el nombre de la ciudad: ");
                            tc.nextLine(); // Limpiar el buffer
                            String nombreCiudad = tc.nextLine();
                            grafo.agregarVertice(nombreCiudad);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        for (int i = 1; i <= num; i++) {
                            System.out.print("Ingrese el índice del vértice origen: ");
                            int origen = tc.nextInt();
                            System.out.print("Ingrese el índice del vértice destino: ");
                            int destino = tc.nextInt();
                            System.out.print("Ingrese el peso: ");
                            double peso = tc.nextDouble();
                            grafo.agregarArco(origen, destino, peso);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    grafo.toString();
                    break;
                case 4:
                    si = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}



