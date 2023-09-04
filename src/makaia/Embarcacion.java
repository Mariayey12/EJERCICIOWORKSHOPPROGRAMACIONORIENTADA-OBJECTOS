package makaia;
abstract class Embarcacion  {
    private Capitan capitan;
    private double precioBase;
    private double valorAdicional;
    private int añoFabricacion;
    private double eslora;

    public Embarcacion(Capitan capitan, double precioBase, double valorAdicional, int añoFabricacion, double eslora) {
        this.capitan = capitan;
        this.precioBase = precioBase;
        this.valorAdicional = valorAdicional;
        this.añoFabricacion = añoFabricacion;
        this.eslora = eslora;
    }

    public Capitan getCapitan() {
        return capitan;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public double getEslora() {
        return eslora;
    }


    // Método abstracto para calcular el alquiler
    public abstract double calcularAlquiler();

}