
public class GameCourse {
	
	private Coordinates coordObj;
	private Spielfeld fieldObj;
	private int size;
	
	public GameCourse(int size, int numMines, int openFields) {
		fieldObj = new Spielfeld(size,numMines,openFields);
		coordObj = new Coordinates(size);
		this.size = size;
	//	fieldObj.printHiddenField();		// its possible for the programmer to print the hidden field at the beginning
	}
	
	public int evaluateWin(char[][] field, char[][] originalField) {	// test if Player won
		for(int i = 1; i < size; i++) {	
			for(int k = 1; k < size; k++) {
				if(field[i][k] == 'X') {
					return 1;	//return 1 if the player lost
				}
			}
		}
		// Test if all fields without mines got revealed:
		for(int i = 1; i < size; i++) {	
			for(int k = 1; k < size; k++) {
				if(originalField[i][k] != field[i][k] && originalField[i][k] != 'X') {
					return 0;	// return 0 if the game has to go on!
				}
			}
		}
		return -1;	// return -1 if Player won the game!
	}
	
	public boolean loopInformation() {
		if(evaluateWin(fieldObj.getShownField(), fieldObj.getField()) == -1 || evaluateWin(fieldObj.getShownField(), fieldObj.getField()) == 1) {
			fieldObj.printField();	// last time the field gets printed before closing the game
			if(evaluateWin(fieldObj.getShownField(), fieldObj.getField()) == -1){
				System.out.println("Sie haben das Spiel gewonnen! ");
			}
			else {
				System.out.println("Sie sind leider auf eine Mine getreten. ");
			}
			coordObj.closeScanner();
			return false;
		}
		return true;
	}
	
	public void printInformation()	{
		// PRINT FIELD:
		fieldObj.printField();
		while(!(coordObj.read())) {	// if false is returnt read again to get a correct statement
			coordObj.read();
		}
		while(!(coordObj.readAction())) {	// if false is returnt read again to get a correct statement
			coordObj.readAction();
		}
		switch(coordObj.getAction()) {
			case 1:
				fieldObj.aufdecken(coordObj.getRow(), coordObj.getColumn());
				break;
			case 2: 
				fieldObj.entschaerfen(coordObj.getRow(), coordObj.getColumn());
				break;
			default:
				System.out.println("Es lief etwas schief. ");
				break;
		}
	}

}