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

	        // Posiciones de la A-Z
	        for (int i = 0; i < filas; i++) {
	            System.out.print((char) ('A' + i) + " "); // Imprime la letra en la fila

	            for (int j = 0; j < columnas; j++) {
	                tablero[i][j] = ' ';
	                System.out.print("| ");
	            }

	            System.out.println("|");
	        }
	    }

	    public static void HacerJugada() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Turno del jugador X");
	        System.out.print("Ingrese la columna para colocar la ficha (1-7): ");
	        int columnaX = scanner.nextInt() - 1;

	        if (columnaX < 0 || columnaX >= columnas || tablero[0][columnaX] != ' ') {
	            System.out.println("Movimiento inválido.");
	            HacerJugada();
	            return;
	        }

	        realizarJugada('X', columnaX);
	        imprimirTablero();

	        System.out.println("Turno del jugador O");
	        System.out.print("Ingrese la columna para colocar la ficha (1-7): ");
	        int columnaO = scanner.nextInt() - 1;

	        if (columnaO < 0 || columnaO >= columnas || tablero[0][columnaO] != ' ') {
	            System.out.println("Movimiento inválido.");
	            HacerJugada();
	            return;
	        }

	        realizarJugada('O', columnaO);
	        imprimirTablero();

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

	    private static void imprimirTablero() {
	        for (int i = 0; i < filas; i++) {
	            System.out.print((char) ('A' + i) + " ");
	            for (int j = 0; j < columnas; j++) {
	                System.out.print("|" + tablero[i][j]);
	            }
	            System.out.println("|");
	        }
	        System.out.println("  ------------");
	    }

	    public static void main(String[] args) {
	        HacerTablero();
	        HacerJugada();
	    }
	}
