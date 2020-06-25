
/**
 *
 * provides a the main-method for the game "minesweeper"
 *
 * @author Philipp, Slebioda, 4809007
 */
public class Minesweeper{

	/**
	 * method main() is the main of the game
	 *
	 *
	 */
	public static void main(String args[]) {
		
		GameCourse gameObj = new GameCourse(10,23,5);	// standard values for fieldsize, number of mines and open fields at beginning, exactly in this order given the constructor
		startInformation();		// first Informations for the player before the gameflow beginns
		do {
			gameObj.printInformation();
		} while(gameObj.loopInformation());	// while false the player hasnt won or lost
	}
	
	/**
	 * static method startInformation() gives some start information at beginning of the program
	 *
	 *
	 */
	public static void startInformation() {
		System.out.println("");
		System.out.println("Willkommen Sie haben das Spiel Minesweeper gestartet!");
		System.out.println("Eine Mine ist durch ein 'X' dargestellt. Eine entschaerfte Mine durch eine '0'.");
		System.out.println("Wenn Sie Zahlen auf dem Feld sehen stehen diese fuer die Anzahl der in der direkt Umgebung befindlichen Minen.");
		System.out.println("");
	}
}