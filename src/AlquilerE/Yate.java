package AlquilerE;

class Yate extends Embarcacion {
    protected int cantCamarotes;

    public Yate(Capitan capitan, double precioBase, double valorAdicional, int añoFabricacion, double eslora, int cantCamarotes) {
        super(capitan, precioBase, valorAdicional, añoFabricacion, eslora);
        this.cantCamarotes = cantCamarotes;
    }

    public boolean esLujo() {
        return cantCamarotes > 7;
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
