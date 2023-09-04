package makaia;

// Clase Velero que hereda de Embarcacion
public class Velero extends Embarcacion {
    private int cantidadMastiles;

    public Velero(double precioBase, double valorAdicional, int añoFabricacion, double eslora, Capitan capitan, int cantidadMastiles) {
        super(capitan, precioBase, valorAdicional, añoFabricacion, eslora);
        this.cantidadMastiles = cantidadMastiles;
    }
    public boolean esGrande() {
        return cantidadMastiles > 4;
    }

    @Override
    public double calcularAlquiler() {
        // Implementación específica del cálculo de alquiler para un velero
        double alquiler = getPrecioBase(); // Inicialmente, el alquiler es igual al precio base de la embarcación

        // Verificamos si el año de fabricación es mayor que 2020
        if (getAñoFabricacion() > 2020) {
            alquiler += getValorAdicional(); // Si es mayor, sumamos el valor adicional al alquiler
        }

        // Añadimos lógica adicional específica para los veleros
        // Por ejemplo, podríamos agregar una tarifa extra si el velero tiene muchos mástiles
        // Supongamos que queremos agregar 5000 por cada mástil adicional después de 4 mástiles
        int mastiles = getCantidadMastiles();
        if (mastiles > 4) {
            int mastilesExtras = mastiles - 4;
            double tarifaMastilesExtras = mastilesExtras * 5000.0;
            alquiler += tarifaMastilesExtras;
        }

        return alquiler;
    }

    public int getCantidadMastiles() {
        return cantidadMastiles;
    }

    public void setCantidadMastiles(int cantidadMastiles) {
        this.cantidadMastiles = cantidadMastiles;
    }
}


