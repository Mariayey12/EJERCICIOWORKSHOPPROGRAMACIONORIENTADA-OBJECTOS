package sistemaparqueadero;

import java.util.Scanner;


public class Mainc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngrese la cantidad de filas del parqueadero: ");
        int filas = scanner.nextInt();
        System.out.print("\nIngrese la cantidad de columnas del parqueadero: ");
        int columnas = scanner.nextInt();
        System.out.print("\nIngrese la tarifa por hora: ");
        double tarifaPorHora = scanner.nextDouble();

        Parqueadero parqueadero = new Parqueadero(filas, columnas, tarifaPorHora);

        System.out.print("\nIngrese la cantidad de carros a registrar: ");
        int cantidadCarros = scanner.nextInt();
        Carro[] carros = new Carro[cantidadCarros];

        for (int i = 0; i < cantidadCarros; i++) {
            System.out.println("\nCarro #" + (i + 1));
            scanner.nextLine(); // Limpia el buffer
            System.out.print("Ingrese la placa: ");
            String placa = scanner.nextLine();
            System.out.print("Ingrese la marca: ");
            String marca = scanner.nextLine();
            System.out.print("Ingrese el modelo: ");
            String modelo = scanner.nextLine();
            carros[i] = new Carro(placa, marca, modelo);
        }

        System.out.println("Registro de carros completado.");

        while (true) {
            System.out.println("\n1. Estacionar carro");
            System.out.println("2. Calcular costo de tiempo");
            System.out.println("3. Mostrar estado del parqueadero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número de carro (1-" + cantidadCarros + "): ");
                    int numCarro = scanner.nextInt();
                    if (numCarro >= 1 && numCarro <= cantidadCarros) {
                        Carro carro = carros[numCarro - 1];
                        System.out.print("Ingrese la fila de estacionamiento: ");
                        int fila = scanner.nextInt();
                        System.out.print("Ingrese la columna de estacionamiento: ");
                        int columna = scanner.nextInt();
                        if (parqueadero.parquearCarro(carro, fila, columna)) {
                            System.out.println("Carro estacionado exitosamente.");
                        } else {
                            System.out.println("No se pudo estacionar el carro.");
                        }
                    } else {
                        System.out.println("Número de carro inválido.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el número de carro (1-" + cantidadCarros + "): ");
                    numCarro = scanner.nextInt();
                    if (numCarro >= 1 && numCarro <= cantidadCarros) {
                        Carro carro = carros[numCarro - 1];
                        System.out.print("Ingrese las horas de estacionamiento: ");
                        int horas = scanner.nextInt();
                        double costo = parqueadero.cobrarPorTiempo(carro, horas);
                        System.out.println("Costo por tiempo: $" + costo);
                    } else {
                        System.out.println("Número de carro inválido.");
                    }
                    break;
                case 3:
                    parqueadero.mostrarEstadoParqueadero();
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
