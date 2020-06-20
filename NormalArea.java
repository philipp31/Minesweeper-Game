
public class NormalArea implements Fieldable{
	
	
	public char getChar(int row, int column, char[][] field, int size) {	// implementation of the Fieldable-Interface
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