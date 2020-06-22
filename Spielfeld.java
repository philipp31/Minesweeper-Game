import java.lang.Math;

/**
 *
 * provides a Spielfeld-class, that allows it to print and fuel the minesweeper-field + allows the operations
 *
 * @author Philipp, Slebioda, 4809007
 */
public class Spielfeld {
	
	private int size;
	private int numMineFields;
	private int openFields;
	private char[][] field;
	private char[][] shownField;
	private NormalArea normArea;
	private Mine mine;
	private int[][] offenePos;
	
	/**
	 * constructor for the class Spielfeld
	 *
	 * @param n size of the field
	 * @param x number of mines that are in the field
	 * @param v number of open fields at the beginning
	 */
	public Spielfeld(int n, int x, int v) {
		offenePos = new int[n][n];
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				offenePos[i][k] = 0;
			}
		}
		normArea = new NormalArea();
		mine = new Mine();
		this.size = n;
		this.numMineFields = x;
		this.openFields = v;
		field = new char[n][n];
		shownField = new char[n][n];
		fuelField();	// field & shownField gets initialized
	}
	
	/**
	 * method getOpenPositions() returns openPositions
	 *
	 * @return offenePos array with the open positions
	 */
	public int[][] getOpenPositions() {
		return offenePos;
	}
	
	/**
	 * method printField() prints the field
	 *
	 */
	public void printField() {	// printing the field for player
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				System.out.print(shownField[i][k] + " | ");
			}
			System.out.println("");	// at the end of each row new line!
			if(i == 0){
				System.out.println("_______________________________________");
				System.out.println("");
			}
		}
	}
	
	/**
	 * method getField() returns the hidden field
	 *
	 * @return field hidden field array
	 */
	public char[][] getField() {
		return field;
	}
	
	/**
	 * method printHiddenField() prints the hidden field
	 *
	 */
	public void printHiddenField() {
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				System.out.print(field[i][k] + " | ");
			}
			System.out.println("");	// at the end of each row new line!
			if(i == 0){
				System.out.println("_______________________________________");
				System.out.println("");
			}
		}
		System.out.println("");
	}
	
	/**
	 * method getShwonField() returns the shown field
	 *
	 * @return shownField 
	 */
	public char[][] getShownField() {
		return shownField;
	}
	
	
	/**
	 * method fuelCoordSystem() fuels the coord. syst. in the array
	 *
	 * @param field field which you want to fuel the coord. sys.
	 */
	private void fuelCoordSystem(char[][] field) {
		int h = 65;
		for(int i = 0; i < size; i++) {
			if(i > 0) {
				field[0][i] = ((char) h);
				field[i][0] = (char) ((48-1)+i);
				h++;
			}
			if(i == 0) field[0][0] = (char) 32;
		}
	}
	
	/**
	 * method fuelShowField() fuels the shown field 
	 *
	 * @param shownField field das you want to be used as shown field
	 */
	private void fuelShowField(char[][] shownField) {
		int randomNum = 0;
		int anzOffenFelder = 0;
		for(int i = 1; i < size; i++) {
			for(int k = 1; k < size; k++) {
				randomNum = ((int) (Math.random()*100));	// double parsen
				if(anzOffenFelder < openFields) {
					if(randomNum > 90) {
						shownField[i][k] = field[i][k];
						anzOffenFelder++;
						offenePos[i][k] = 3;
					}
					else {
						shownField[i][k] = ((char) 32);
					}
				}
				else {
					shownField[i][k] = ((char) 32);
				}
			}
		}
	}
	
	/**
	 * method fuelField() fuels all fields so that the game is ready to play
	 *
	 */
	private void fuelField() {
		int anzMinen = 0;
		fuelCoordSystem(field);
		fuelCoordSystem(shownField);
		int randomNum = 0;
		for(int i = 1; i < size; i++) {	// mines get positioned through coincidense
			for(int k = 1; k < size; k++) {
				if(anzMinen < numMineFields) {	// mines are random + we want a specific number of mines
					randomNum = ((int) (Math.random()*100));	// double parsen
					if(randomNum > 60) {
						field[i][k] = mine.getChar(i,k,field,size);	
						anzMinen++;
					}
				}
			}
		}
		for(int i = 1; i < size; i++) {
			for(int k = 1; k < size; k++) {
				if(((int) field[i][k]) == 0) {
					try {
						field[i][k] = normArea.getChar(i,k,field,size);	// getChar returns the num. of mine fields in the direct location of the field
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Es wurde auf einen Index zugegriffen der nicht existent ist. ");
					}
				}
			}
		}
		fuelShowField(shownField);
	}
	
	/**
	 * method entschaerfen() is the move into move of the player
	 *
	 * @param row row
	 * @param column column
	 */
	public void entschaerfen(int row, int column) {
		if(field[row][column] == 'X') {	// DEFUSE MINE
			shownField[row][column] = '0';	
		}
		else {	// IF THERE ISNT A MINE, SHOW NUM OF MINES
			shownField[row][column] = field[row][column];
		}
	}
	
	/**
	 * method aufdecken() is the move defuse of the player
	 *
	 * @param row row
	 * @param column column
	 */
	public void aufdecken(int row, int column) {
		shownField[row][column] = field[row][column];	// reveal the symbol thats under this pos.
	}

}