
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
		
		GameCourse gameObj = new GameCourse(10,23,5);	// standard values for fieldsize, number of mines and open fields at beginning
		
		do {
			gameObj.printInformation();
		} while(gameObj.loopInformation());	// while false the player hasnt won or lost
	}
}