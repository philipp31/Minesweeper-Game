
/**
 *
 * provides a GameCourse-class that controlls the game-flow of the game "minesweeper"
 *
 * @author Philipp, Slebioda, 4809007
 */
public class GameCourse {
	
	private Coordinates coordObj;
	private Spielfeld fieldObj;
	private int size;
	
	/**
	 * constructor for the class GameCourse
	 *
	 * @param size size of the field
	 * @param numMines number of mines that are in the field
	 * @param openFields number of open fields at the beginning
	 */
	public GameCourse(int size, int numMines, int openFields) {
		fieldObj = new Spielfeld(size,numMines,openFields);
		coordObj = new Coordinates(size);
		this.size = size;
	//	fieldObj.printHiddenField();		// its possible for the programmer to print the hidden field at the beginning
	}
	
	/**
	 * method evaluateWin() evaluates if the player won or lost
	 *
	 * @param field shown field
	 * @param originalField is the hidden field
	 * @param openFields is the array which indicates which parts were open at the beginning
	 * @return int which indicates if player lost/won
	 */
	public int evaluateWin(char[][] field, char[][] originalField, int[][] openFields) {	// test if Player won
		for(int i = 1; i < size; i++) {	
			for(int k = 1; k < size; k++) {
				if(field[i][k] == 'X' && (openFields[i][k] != 3)) {
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
	
	/**
	 * method loopInformation() gives for the games loop the condition
	 *
	 * @return boolean condition
	 */
	public boolean loopInformation() {
		if(evaluateWin(fieldObj.getShownField(), fieldObj.getField(), fieldObj.getOpenPositions()) == -1 || evaluateWin(fieldObj.getShownField(), fieldObj.getField(),fieldObj.getOpenPositions()) == 1) {
			fieldObj.printField();	// last time the field gets printed before closing the game
			if(evaluateWin(fieldObj.getShownField(), fieldObj.getField(), fieldObj.getOpenPositions()) == -1){
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
	
	/**
	 * method printInformation() prints in every step the game and causes the game flow
	 *
	 *
	 */
	public void printInformation()	{
		System.out.println("");
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