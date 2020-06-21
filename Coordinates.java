import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * provides a Coordinates-class for scanning input and checking if it is correct
 *
 * @author Philipp, Slebioda, 4809007
 */
public class Coordinates {
	
	public int zeile;
	private char spalte;
	public int spalteInt;
	private Scanner reader;
	private int size;
	private int action;
	private String cache;
	
	/**
	 * constructor for the class Coordinates
	 *
	 * @param size of the field
	 */
	public Coordinates(int size) {
		reader = new Scanner(System.in);
		reader.useDelimiter("");	//every symbol should be extracted seperatly
		this.size = size;
	}
	
	/**
	 * method read() scans the first players input
	 *
	 * @return true or false depends if the input is correct(true) or it makes no sense(false)
	 */
	public boolean read() {
		System.out.println("Bitte geben Sie Ihren Zug an(Bsp.: A1). Bitte die Spalte als grossen Buchstaben angeben!! ");
		System.out.println("Ihre Eingabe lautet: ");
		// short term memory for players move:
		char zwSpalte;
		int zwZeile;
		try {
			zwSpalte = reader.next().charAt(0);		// parse char
			zwZeile = reader.nextInt();				// parse int
		}
		catch (InputMismatchException e) {
			System.out.println("***** FEHLER ! ******* ");
			System.out.println("Das eingegebene Format ist leider falsch! Erst Buchstaben, dann Zahl angeben! ");
			zwSpalte = 'z';	// choosing false values to cause a false return!
			zwZeile = (-1);
		}
		reader.next();
		reader.next();
		if(checkCoord(zwSpalte,zwZeile,size)) {	// check if the "move" was successfull
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * method closeScanner() closes the scanner
	 *
	 * 
	 */
	public void closeScanner() {
		reader.close();
	}
	
	/**
	 * method readAction() scans the second players input
	 *
	 * @return true or false depends if the input is correct(true) or it makes no sense(false)
	 */
	public boolean readAction() {
		System.out.print("Enter action(1 for 'move onto', 2 for 'defuse'): ");
		try {
			action = reader.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("***** FEHLER ! ******* ");
			System.out.println("Das eingegebene Format ist leider falsch! (Zahl 1 oder 2 gefordert!) ");
			action = 5;	// choosing false values to cause a false return!
		}
		reader.next();
		reader.next();
		System.out.println("");
		if(action > 2 || action < 1) {
			return false;	// return false for false input
		}
		return true;
	}
	
	/**
	 * method getAction() returns the param action
	 *
	 * @return action
	 */
	public int getAction() {
		return action;
	}
	
	/**
	 * method checkCoord() checks if the coord pair is legit
	 *
	 * @return true or false depends if the input makes sense(true) or it makes no sense(false)
	 */
	public boolean checkCoord(char column, int row, int fieldSize) {
		int spalt, zeil;
		zeil = (row+1);	// add 1 because of the direct adressing of char[][]-arr.
		spalteInt = (((int) (column)) - 64);
		if(!(zeil >= size) && !(spalteInt >= size)){
			zeile = zeil;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * method getRow() returns row
	 *
	 * @return zeile the param for row
	 */
	public int getRow() {
		return zeile;
	}
	
	/**
	 * method getColumn() returns column
	 *
	 * @return spalteInt the param for column
	 */
	public int getColumn() {
		return spalteInt;
	}
}