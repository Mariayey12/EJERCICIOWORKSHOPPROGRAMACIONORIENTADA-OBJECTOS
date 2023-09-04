package parqueadero;

public class Main {
    public static void main(String[] args) {
    Parqueadero parqueadero = new Parqueadero(5, 10, 5.0);

    Carro carro1 = new Carro("ABC123", "Toyota", "Corolla");
    Carro carro2 = new Carro("XYZ789", "Honda", "Civic");
    Carro carro3 = new Carro("DEF456", "Ford", "Focus");

        System.out.println("\nCreando instancia de Parqueadero...");

        System.out.println("\nCreando carros...");

        System.out.println("\nIntentando estacionar carros...");


        if (parqueadero.parquearCarro(carro1, 2, 3)) {
            System.out.println("Carro 1 estacionado exitosamente.");
        }

        if (parqueadero.parquearCarro(carro2, 1, 6)) {
            System.out.println("Carro 2 estacionado exitosamente.");
        }

        if (!parqueadero.parquearCarro(carro3, 2, 3)) {
            System.out.println("El espacio ya está ocupado.");
        }

        System.out.println("Calculando costos de tiempo...");

    double costoCarro1 = parqueadero.cobrarPorTiempo(carro1, 3);{
        System.out.println("Costo por tiempo del Carro 1: $" + costoCarro1);

        System.out.println("Mostrando estado del parqueadero...");

        parqueadero.mostrarEstadoParqueadero();}
}}

