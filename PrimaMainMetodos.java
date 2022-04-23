package prima;

import java.util.Scanner;

/**
 * <h1>Clase para calcular la prima de un empleado</h1>
 * 
 * Esta clase implementa el método Main para ejecutar un programa de consola que
 * toma los datos necesarios para calcular la prima correspondiente a un
 * empleado dado. Todos sus métodos son métodos de clase.
 * 
 * @author Ramón García
 * @version 1.0
 * @see java.util.Scanner
 */
public class PrimaMainMetodos {
	/**
	 * Objeto que lee los datos de entrada. Se declara aquí para que pueda ser
	 * utilizado por cualquier método.
	 */
	static Scanner teclado = new Scanner(System.in);

	/**
	 * Este método principal del programa recoge uno a uno los datos necesarios para
	 * calcular la prima de cada empleado que se requiera.
	 * 
	 * @param args Se pone por convención. En este caso no se utiliza porque no se
	 *             pasan parámetros al programa.
	 */
	public static void main(String[] args) {

		int numEmple;
		String nomEmple;
		int meses;
		char esDirectivo;
		char respuesta;

		do {
			System.out.println("\nDATOS  EMPLEADO/A");
			numEmple = leerNumEmple();
			nomEmple = leerNomEmple();
			meses = leerMeses();
			esDirectivo = leerEsDirectivo();
			System.out.println("\n\tLe corresponde la prima " + hallarPrima(esDirectivo, meses));

			System.out.println("\n¿CALCULAR MAS PRIMAS? (S/N): ");
			respuesta = teclado.nextLine().toUpperCase().charAt(0);
		} while (respuesta == 'S');
	}

	/**
	 * Calcula la prima correspondiente en función de si el empleado es o no
	 * directivo y los meses que lleva en la empresa.
	 * 
	 * @param esDirectivo La opción dada por el usuario (+ o -).
	 * @param meses       Número de meses que el empleado lleva en la empresa.
	 * @return Código de la prima que corresponde al empleado.
	 */
	public static String hallarPrima(char esDirectivo, int meses) {
		if (esDirectivo == '+') // ES DIRECTIVO
			if (meses >= 12)
				return "P1";
			else
				return "P3";
		else // NO ES DIRECTIVO
		if (meses >= 12)
			return "P2";
		else
			return "P4";
	}

	/**
	 * Solicita y recoge el número de empleado.
	 * 
	 * @return El número de empleado.
	 */
	public static int leerNumEmple() {
		int numEmple;
		do {
			System.out.println("NÚMERO [100-999]: ");
			numEmple = teclado.nextInt();
		} while (numEmple < 100 || numEmple > 999);
		teclado.nextLine();
		return numEmple;
	}

	/**
	 * Solicita y recoge el nombre del empleado.
	 * 
	 * @return El nombre del empleado.
	 */
	public static String leerNomEmple() {
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		} while (nomEmple.length() > 10);
		return nomEmple;
	}

	/**
	 * Solicita y recoge el número de meses que el empleado lleva en la empresa.
	 * 
	 * @return El número de meses.
	 */
	public static int leerMeses() {
		int meses;
		do {
			System.out.println("MESES DE TRABAJO: ");
			meses = teclado.nextInt();
		} while (meses < 0);
		teclado.nextLine();
		return meses;
	}

	/**
	 * Solicita y recoge el dato de sí el empleado es o no directivo.
	 * 
	 * @return Carácter (+ o -) que representa verdadero y falso respectivamente.
	 */
	public static char leerEsDirectivo() {
		char esDirectivo;
		do {
			System.out.println("¿ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		} while (esDirectivo != '+' && esDirectivo != '-');
		return esDirectivo;
	}
}
