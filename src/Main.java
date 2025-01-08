import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Mapa mapa = new Mapa(6, 20);

        System.out.print("Introduce el nombre del explorador: ");
        String nombreExplorador = scanner.nextLine();
        Explorador explorador = new Explorador(nombreExplorador, mapa.getFilas(), mapa.getColumnas());

        // Crear los enemigos
        Enemigo enemigo1 = new Enemigo("Enemigo1", mapa.getFilas(), mapa.getColumnas());
        Enemigo enemigo2 = new Enemigo("Enemigo2", mapa.getFilas(), mapa.getColumnas());
        Enemigo enemigo3 = new Enemigo("Enemigo3", mapa.getFilas(), mapa.getColumnas());

        Enemigo[] enemigos = {enemigo1, enemigo2, enemigo3};

        // Colocar al explorador y enemigos en el mapa
        mapa.colocarExplorador(explorador.getPosicion(), 'J');
        mapa.colocarEnemigo(enemigo1.getPosicion(), 'E');
        mapa.colocarEnemigo(enemigo2.getPosicion(), 'E');
        mapa.colocarEnemigo(enemigo3.getPosicion(), 'E');

        System.out.println("*******************************************************");
        System.out.println("Bienvenido al juego del explorador");
        System.out.println("*******************************************************");
        mapa.mostrarMapa();

        while (true) {
            System.out.println("Turno del explorador:");
            System.out.println("W = Arriba, A = Izquierda, S = Abajo, D = Derecha");
            System.out.print("¿Qué acción quieres realizar? ");
            char direccion = scanner.next().toUpperCase().charAt(0);

            explorador.moverse(direccion + "", mapa);

            mapa.mostrarMapa();

            if (explorador.haEncontradoTesoro(mapa)) {
                System.out.println("¡Has encontrado el tesoro! ¡Has ganado!");
                break;
            }

            if (explorador.haCaidoEnTrampa(mapa)) {
                System.out.println("¡Has caído en una trampa! ¡Has perdido!");
                break;
            }


            enemigo1.moverse(mapa);
            enemigo2.moverse(mapa);
            enemigo3.moverse(mapa);

            mapa.mostrarMapa();

            if (explorador.estaConEnemigos(enemigos)) {
                System.out.println("¡Un enemigo te ha atrapado! ¡Has perdido!");
                break;
            }
        }

    }
}
