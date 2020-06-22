
/**
 *
 * provides a interface for two field-types in minsweeper: Mine Areas and Normal Areas
 *
 * @author Philipp, Slebioda, 4809007
 */
public interface Fieldable {
	
	/**
	 * abstract method getChar() 
	 *
	 * @param row row
	 * @param column column
	 * @param field field
	 * @param size
	 *
	 */
	public char getChar(int row, int column, char[][] field, int size);
}