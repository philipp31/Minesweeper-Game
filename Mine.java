
/**
 *
 * provides a mine-class that describes mine behaviour
 *
 * @author Philipp, Slebioda, 4809007
 */
public class Mine implements Fieldable {
	
	public char getChar(int row, int column, char[][] field, int size) {
		return 'X';				// implementation of the fieldable-interface
	}
}