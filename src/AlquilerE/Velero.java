package AlquilerE;

class Velero extends Embarcacion {
    protected int cantMastiles;

    public Velero(Capitan capitan, double precioBase, double valorAdicional, int añoFabricacion, double eslora, int cantMastiles) {
        super(capitan, precioBase, valorAdicional, añoFabricacion, eslora);
        this.cantMastiles = cantMastiles;
    }

    public boolean esGrande() {
        return cantMastiles > 4;
    }

    @Override
    public double calcularMontoAlquiler() {
        double monto = getPrecioBase();
        if (getAñoFabricacion() > 2020) {
            monto += getValorAdicional();
        }
        return monto;
    }
}
