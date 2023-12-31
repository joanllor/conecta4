package Game;

import java.util.Scanner;

public class Conecta4 {

    public static int filas = 6;
    public static int columnas = 7;
    public static char[][] tablero;

    public static void HacerTablero() {
        tablero = new char[filas][columnas];

        // Numeración de las columnas
        System.out.print("  ");
        for (int i = 1; i <= columnas; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = ' ';
                System.out.print("| ");
            }
            System.out.println("|");
        }
    }

    public static void HacerJugada() {
        Scanner scanner = new Scanner(System.in);

        char ganador = ' ';

        while (ganador == ' ') {
            System.out.println("Turno del jugador X");
            System.out.print("Ingrese la columna para colocar la ficha (1-7): ");
            int columnaX = scanner.nextInt() - 1;

            if (columnaX < 0 || columnaX >= columnas || tablero[0][columnaX] != ' ') {
                System.out.println("Movimiento inválido. Inténtelo de nuevo.");
                continue;
            }

            realizarJugada('X', columnaX);
            imprimirTablero();
            ganador = verificarGanador();
            if (ganador != ' ') break;

            System.out.println("Turno del jugador O");
            System.out.print("Ingrese la columna para colocar la ficha (1-7): ");
            int columnaO = scanner.nextInt() - 1;

            if (columnaO < 0 || columnaO >= columnas || tablero[0][columnaO] != ' ') {
                System.out.println("Movimiento inválido. Inténtelo de nuevo.");
                continue;
            }

            realizarJugada('O', columnaO);
            imprimirTablero();
            ganador = verificarGanador();
        }

        if (ganador != ' ') {
            System.out.println("¡El jugador " + ganador + " ha ganado!");
        } else {
            System.out.println("¡Empate!");
        }

        scanner.close();
    }

    public static void realizarJugada(char ficha, int columna) {
        for (int i = filas - 1; i >= 0; i--) {
            if (tablero[i][columna] == ' ') {
                tablero[i][columna] = ficha;
                break;
            }
        }
    }

    public static void imprimirTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("|" + tablero[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("  ------------");
    }

    public static char verificarGanador() {
        // Verificar filas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j <= columnas - 4; j++) {
                char ficha = tablero[i][j];
                if (ficha != ' ' &&
                        ficha == tablero[i][j + 1] &&
                        ficha == tablero[i][j + 2] &&
                        ficha == tablero[i][j + 3]) {
                    return ficha;
                }
            }
        }

        // Verificar columnas
        for (int i = 0; i <= filas - 4; i++) {
            for (int j = 0; j < columnas; j++) {
                char ficha = tablero[i][j];
                if (ficha != ' ' &&
                        ficha == tablero[i + 1][j] &&
                        ficha == tablero[i + 2][j] &&
                        ficha == tablero[i + 3][j]) {
                    return ficha;
                }
            }
        }

        // Verifica diagonales de arriba a abajo
        for (int i = 0; i <= filas - 4; i++) {
            for (int j = 0; j <= columnas - 4; j++) {
                char ficha = tablero[i][j];
                if (ficha != ' ' &&
                        ficha == tablero[i + 1][j + 1] &&
                        ficha == tablero[i + 2][j + 2] &&
                        ficha == tablero[i + 3][j + 3]) {
                    return ficha;
                }
            }
        }

        // Verifica diagonales de abajo a arriba
        for (int i = 3; i < filas; i++) {
            for (int j = 0; j <= columnas - 4; j++) {
                char ficha = tablero[i][j];
                if (ficha != ' ' &&
                        ficha == tablero[i - 1][j + 1] &&
                        ficha == tablero[i - 2][j + 2] &&
                        ficha == tablero[i - 3][j + 3]) {
                    return ficha;
                }
            }
        }

        return ' '; // No hay ganador 
    }

    public static void main(String[] args) {
        HacerTablero();
        HacerJugada();
    }
}
