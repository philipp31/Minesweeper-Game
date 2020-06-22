
/**
 *
 * provides a mine-class that describes mine behaviour and implements the fieldable interface
 *
 * @author Philipp, Slebioda, 4809007
 */
public class Mine implements Fieldable {
	
	/**
	 * abstract method getChar() gets defined
	 *
	 * @param row row
	 * @param column column
	 * @param field field
	 * @param size
	 *
	 */
	public char getChar(int row, int column, char[][] field, int size) {
		return 'X';				// implementation of the fieldable-interface
	}
}