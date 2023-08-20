package AlquilerE;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainAlquiler {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Random random = new Random();
        List<Embarcacion> embarcaciones = new ArrayList<>();
        System.out.println("Bienvenido al sistema de alquiler de embarcaciones de MAKAI");
        System.out.print("Ingrese la cantidad de embarcaciones a crear: ");
        int cantidadEmbarcaciones =  sc.nextInt();

        //*****************************************************************//
        // Generación de embarcaciones aleatorias
        for (int i = 0; i < cantidadEmbarcaciones; i++) {
            Capitan capitan = new Capitan("Maria" + i, "Mora","MAT" + i);
            double precioBase = random.nextDouble() * 1000 + 500;
            double valorAdicional = random.nextDouble() * 200;
            int añoFabricacion = random.nextInt(10) + 2010;
            double eslora = random.nextDouble() * 20 + 5;
            int cantMastiles = random.nextInt(6);
            int cantCamarotes = random.nextInt(10);

            Embarcacion embarcacion;
            if (cantMastiles > 0) {
                embarcacion = new Velero(capitan, precioBase, valorAdicional, añoFabricacion, eslora, cantMastiles);
            } else {
                embarcacion = new Yate(capitan, precioBase, valorAdicional, añoFabricacion, eslora, cantCamarotes);
            }
            embarcaciones.add(embarcacion);
        }
        //*****************************************************************//
        // Mostrar información de las embarcaciones
        System.out.println("\nInformación de las embarcaciones:");
        for (int i = 0; i < embarcaciones.size(); i++) {
            Embarcacion embarcacion = embarcaciones.get(i);
            System.out.println("\nEmbarcación #" + (i + 1));
            System.out.println("Tipo: " + (embarcacion instanceof Velero ? "Velero" : "Yate"));
            System.out.println("Capitán: " + embarcacion.getCapitan().getNombre() + " " + embarcacion.getCapitan().getApellido());
            System.out.println("Matrícula del capitán: " + embarcacion.getCapitan().getMatricula());
            System.out.println("Precio base: " + embarcacion.getPrecioBase());
            System.out.println("Valor adicional: " + embarcacion.getValorAdicional());
            System.out.println("Año de fabricación: " + embarcacion.getAñoFabricacion());
            System.out.println("Eslora: " + embarcacion.getEslora());
            if (embarcacion instanceof Velero) {
                Velero velero = (Velero) embarcacion;
                System.out.println("Cantidad de mástiles: " + velero.cantMastiles);
                System.out.println("Es grande: " + velero.esGrande());
            } else {
                Yate yate = (Yate) embarcacion;
                System.out.println("Cantidad de camarotes: " + yate.cantCamarotes);
                System.out.println("Es de lujo: " + yate.esLujo());
            }
            double montoAlquiler = embarcacion.calcularMontoAlquiler();
            System.out.println("Monto del alquiler: $" + montoAlquiler);
        }
    }
}


