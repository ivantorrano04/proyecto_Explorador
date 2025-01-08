public class Mapa {
    private char[][] mapa;
    private int filas;
    private int columnas;

    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        mapa = new char[filas][columnas];
        inicializarMapa();
    }

    private void inicializarMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                mapa[i][j] = ' ';
            }
        }
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    //limpiar la consola
    public void limpiarPantalla() {
        //se me duplicaba todo el rato asi que he buscado en internet y me funciona asi
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void mostrarMapa() {
        limpiarPantalla();
        StringBuilder sb = new StringBuilder();
        sb.append("*******************************************************\n");
        sb.append("Bienvenido al juego del explorador\n");
        sb.append("*******************************************************\n");

        for (int i = 0; i < filas; i++) {
            sb.append("|");
            for (int j = 0; j < columnas; j++) {
                char simbolo = mapa[i][j];
                if (simbolo == 'J') {
                    sb.append("\033[32m" + simbolo + "\033[0m");  // Verde para el explorador
                } else if (simbolo == 'E') {
                    sb.append("\033[31m" + simbolo + "\033[0m");  // Rojo para los enemigos
                } else {
                    sb.append(" " + simbolo + " ");
                }
                sb.append("|");
            }
            sb.append("\n");
            sb.append("-".repeat(columnas * 4 + 1) + "\n");
        }
        System.out.print(sb.toString());
    }

    public void colocarExplorador(Posicion posicion, char simbolo) {
        mapa[posicion.getCoordenadaFila()][posicion.getCoordenadaCol()] = simbolo;
    }

    public void colocarEnemigo(Posicion posicion, char simbolo) {
        mapa[posicion.getCoordenadaFila()][posicion.getCoordenadaCol()] = simbolo;
    }

    public void limpiarPosicion(Posicion posicion) {
        mapa[posicion.getCoordenadaFila()][posicion.getCoordenadaCol()] = ' ';
    }

    public boolean esPosicionOcupada(Posicion posicion) {
        return mapa[posicion.getCoordenadaFila()][posicion.getCoordenadaCol()] != ' ';
    }

    public boolean posicionValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public char obtenerSimbolo(Posicion posicion) {
        return mapa[posicion.getCoordenadaFila()][posicion.getCoordenadaCol()];
    }
}
