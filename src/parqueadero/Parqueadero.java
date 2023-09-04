package parqueadero;

public class Parqueadero {

    private Carro[][] matrizParqueadero;
    private double tarifaPorHora;

    public Parqueadero(int filas, int columnas, double tarifaPorHora) {
        matrizParqueadero = new Carro[filas][columnas];
        this.tarifaPorHora = tarifaPorHora;
    }
//La validación de que un carro no se pueda parquear en una celda que ya está ocupada se realiza en
// el método parquearCarro() de la clase Parqueadero. Aquí está el fragmento relevante del código:

//Se verifica si los índices fila y columna están dentro de los límites válidos de la matriz matrizParqueadero.
// Si los índices están fuera de los límites de la matriz (fila < 0, fila >= número de filas, columna < 0, columna >= número de columnas),
// se considera que la celda está fuera del parqueadero y se retorna false.
    public boolean parquearCarro(Carro carro, int fila, int columna) {
        if (fila < 0 || fila >= matrizParqueadero.length || columna < 0 || columna >= matrizParqueadero[0].length) {
            return false; // Fuera de los límites de la matriz
        }
        if (matrizParqueadero[fila][columna] == null) {
            matrizParqueadero[fila][columna] = carro;
            return true;
        }

        return false;  // Espacio ocupado
}

    public double cobrarPorTiempo(Carro carro, int horas) {
        return horas * tarifaPorHora;
    }

    public void mostrarEstadoParqueadero() {
        System.out.println("Estado del Parqueadero:");
        for (int fila = 0; fila < matrizParqueadero.length; fila++) {
            for (int columna = 0; columna < matrizParqueadero[0].length; columna++) {
                if (matrizParqueadero[fila][columna] != null) {
                    System.out.print("X ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}
