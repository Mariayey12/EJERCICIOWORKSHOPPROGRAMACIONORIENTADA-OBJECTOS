package makaia;

// Clase Yate que hereda de Embarcacion
public class Yate extends Embarcacion {
    private int cantidadCamarotes;

    public Yate(double precioBase, double valorAdicional, int añoFabricacion, double eslora, Capitan capitan, int cantidadCamarotes) {
        super(capitan, precioBase, valorAdicional, añoFabricacion, eslora);
        this.cantidadCamarotes = cantidadCamarotes;
    }
    public boolean esLujo() {
        return cantidadCamarotes > 7;
    }
    @Override
    public double calcularAlquiler() {
        // Implementación específica del cálculo de alquiler para un yate
        double alquiler = getPrecioBase(); // Inicialmente, el alquiler es igual al precio base de la embarcación

        // Verificamos si el año de fabricación es mayor que 2020
        if (getAñoFabricacion() > 2020) {
            alquiler += getValorAdicional(); // Si es mayor, sumamos el valor adicional al alquiler
        }

        // Añadimos lógica adicional específica para los yates
        // Por ejemplo, podríamos agregar una tarifa extra si el yate tiene más de 7 camarotes
        // Supongamos que deseamos agregar 10,000 por cada camarote adicional después de 7 camarotes
        int camarotes = getCantidadCamarotes();
        if (camarotes > 7) {
            int camarotesExtras = camarotes - 7;
            double tarifaCamarotesExtras = camarotesExtras * 10000.0;
            alquiler += tarifaCamarotesExtras;
        }

        return alquiler;
    }


    public int getCantidadCamarotes() {
        return cantidadCamarotes;
    }

    public void setCantidadCamarotes(int cantidadCamarotes) {
        this.cantidadCamarotes = cantidadCamarotes;
    }
}
