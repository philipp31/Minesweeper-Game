
/**
 *
 * provides a NormalArea-class that describes the normal area in minesweeper and implements the fieldable interface
 *
 * @author Philipp, Slebioda, 4809007
 */
public class NormalArea implements Fieldable {
	
	/**
	 * abstract method getChar() gets defined
	 *
	 * @param row row
	 * @param column column
	 * @param field field
	 * @param size
	 *
	 */
	public char getChar(int row, int column, char[][] field, int size) throws ArrayIndexOutOfBoundsException {	// implementation of the Fieldable-Interface
		int num = 0;
		int versch = -1;
		while(versch < 2) {
			if((row-1) > 0 && (row-1) < size && (column+versch) > 0 && (column+versch) < size){
				if(field[(row-1)][(column + versch)] == 'X' && (row-1) > 0 && (column+versch) > 0) {
					num++;
				}
			}
			if((row) > 0 && (row) < size && (column+versch) > 0 && (column+versch) < size){
				if(field[(row)][(column + versch)] == 'X' && (row) > 0 && (column+versch) > 0) {
					num++;
				}
			}
			if((row+1) > 0 && (row+1) < size && (column+versch) > 0 && (column+versch) < size){
				if(field[(row+1)][(column + versch)] == 'X' && (row+1) > 0 && (column+versch) > 0) {
					num++;
				}
			}
		versch++;
		}
		return ((char) (num+48));
	}
	
}