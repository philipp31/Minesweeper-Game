import java.lang.Math;

public class Spielfeld {
	
	private int size;
	private int numMineFields;
	private int openFields;
	private char[][] field;
	private char[][] shownField;
	private NormalArea normArea;
	private Mine mine;
	
	
	public Spielfeld(int n, int x, int v) {
		normArea = new NormalArea();
		mine = new Mine();
		this.size = n;
		this.numMineFields = x;
		this.openFields = v;
		field = new char[n][n];
		shownField = new char[n][n];
		fuelField();	// field & shownField gets initialized
	}
	
	public void printField() {	// Ausgabe des Feldes für den Spieler!
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
	
	public char[][] getField() {
		return field;
	}
	
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
	
	public char[][] getShownField() {
		return shownField;
	}
	
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
	
	private void fuelShowField(char[][] field) {
		for(int i = 1; i < size; i++) {
			for(int k = 1; k < size; k++) {
				shownField[i][k] = ((char) 32);
			}
		}
	}
	
	private void fuelField() {
		fuelCoordSystem(field);
		fuelCoordSystem(shownField);
		fuelShowField(shownField);
		int randomNum = 0;
		for(int i = 1; i < size; i++) {	// mines get positioned through coincidense
			for(int k = 1; k < size; k++) {
				randomNum = (int) (Math.random()*100);	// double parsen
				if(randomNum > 80) {
					field[i][k] = mine.getChar(i,k,field,size);					
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
	}
	
	public void entschaerfen(int row, int column) {
		if(field[row][column] == 'X') {	// DEFUSE MINE
			shownField[row][column] = '0';	
		}
		else {	// IF THERE ISNT A MINE, SHOW NUM OF MINES
			shownField[row][column] = field[row][column];
		}
	}
	
	public void aufdecken(int row, int column) {
		shownField[row][column] = field[row][column];	// reveal the symbol thats under this pos.
	}

}