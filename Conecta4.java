package Game;

public class Conecta4 {

	
	  public static void HacerTablero() {
		  int filas = 6;
	        int columnas = 7;

	        // numero de las columnas
	        System.out.print("  ");
	        for (int i = 1; i <= columnas; i++) {
	            System.out.print(" " + i);
	        }
	        System.out.println();

	        // posiciones de la A-Z
	        for (int i = 0; i < filas; i++) {
	            System.out.print((char) ('A' + i) + " "); // Imprime la letra en la fila

	            for (int j = 0; j < columnas; j++) {
	                System.out.print("| ");
	            }

	            System.out.println("|"); 
	        }
	  }

	  public static void HacerJugada() {
		  
		  
		  
		  
		  
	  }
	
	public static void main(String[] args) {
		
		HacerTablero();

	}

}
