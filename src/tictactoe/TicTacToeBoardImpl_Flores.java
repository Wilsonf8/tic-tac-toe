package tictactoe;



public class TicTacToeBoardImpl_Flores implements TicTacToeBoard{
	//Symbolics:
	protected static final int NO_MOVE = -1;
	protected static final int NO_MATCH = -1;
	protected int[] movesArray;
	
	public TicTacToeBoardImpl_Flores() {
		final int CELL_COUNT = ROW_COUNT*COLUMN_COUNT;
		movesArray = new int[CELL_COUNT];
		for(int i = 0; i < CELL_COUNT; i++){
			movesArray[i] = NO_MOVE;
		}
	}
	
	@Override
	public Mark getMark(int row, int column) {
		
		assert row < 3; 
		assert row >= 0;
		assert column < 3; 
		assert column >= 0;
		
		int numberToFind = row * 3 + column;
		
		for(int j = 0; j < movesArray.length; j++) {
			if(movesArray[j] == numberToFind && j % 2 == 0) {
				return Mark.X;
			}
			if(movesArray[j] == numberToFind && j % 2 == 1) {
				return Mark.O;
			}
		}
		return null;
	}

	@Override
	public void setMark(int row, int column) {
		
		assert row < 3; 
		assert row >= 0;
		assert column < 3; 
		assert column >= 0;
		assert getMark(row, column) == null;
		assert isGameOver() == false;
		
		int numberToAdd = row * 3 + column;
		for (int t = 0; t < movesArray.length; t++) {
			if (movesArray[t] == numberToAdd) {
				assert false;
			}
		}
		
		for(int j = 0; j < movesArray.length; j++) {
			if(movesArray[j] == -1) {
				movesArray[j] = numberToAdd;
				j = movesArray.length;
			}
		}
		
	}

	@Override
	public Mark getTurn() {
		int numOfNonNegativeNumbers = 0;
		for(int y = 0; y < movesArray.length; y++) {
			if (movesArray[y] != -1) {
				numOfNonNegativeNumbers += 1;
			}
		}
		
		if (numOfNonNegativeNumbers % 2 == 0) {
			return Mark.X;
		}
		
		return Mark.O;
	}

	@Override
	public boolean isGameOver() {
		
		if(getMark(0, 0) == getMark(0, 1) && getMark(0, 1) == getMark(0, 2) && getMark(0, 0) != null) {return true;} // Horizontal Check
		if(getMark(1, 0) == getMark(1, 1) && getMark(1, 1) == getMark(1, 2) && getMark(1, 0) != null) {return true;} // Horizontal Check
		if(getMark(2, 0) == getMark(2, 1) && getMark(2, 1) == getMark(2, 2) && getMark(2, 0) != null) {return true;} // Horizontal Check
		
		if(getMark(0, 0) == getMark(1, 0) && getMark(2, 0) == getMark(0, 0) && getMark(0, 0) != null) {return true;} // Vertical Check
		if(getMark(0, 1) == getMark(1, 1) && getMark(1, 1) == getMark(2, 1) && getMark(0, 1) != null) {return true;} // Vertical Check
		if(getMark(0, 2) == getMark(1, 2) && getMark(2, 2) == getMark(0, 2) && getMark(0, 2) != null) {return true;} // Vertical Check
		
		if(getMark(0, 0) == getMark(1, 1) && getMark(0, 0) == getMark(2, 2) && getMark(0, 0) != null) {return true;} // Diagonal Check
		if(getMark(0, 2) == getMark(1, 1) && getMark(0, 2) == getMark(2, 0) && getMark(0, 2) != null) {return true;} // Diagonal Check
		
		if (noEmptySpots()) {return true;}
		return false;
		
	}

	@Override
	public Mark getWinner() {
		
		assert isGameOver(); // assert if game is not over
		
		if(getMark(0, 0) == getMark(0, 1) && getMark(0, 1) == getMark(0, 2) && getMark(0, 0) != null) {return getMark(0, 0);} // Horizontal Check
		if(getMark(1, 0) == getMark(1, 1) && getMark(1, 1) == getMark(1, 2) && getMark(1, 0) != null) {return getMark(1, 0);} // Horizontal Check
		if(getMark(2, 0) == getMark(2, 1) && getMark(2, 1) == getMark(2, 2) && getMark(2, 0) != null) {return getMark(2, 0);} // Horizontal Check
		
		if(getMark(0, 0) == getMark(1, 0) && getMark(2, 0) == getMark(0, 0) && getMark(0, 0) != null) {return getMark(0, 0);} // Vertical Check
		if(getMark(0, 1) == getMark(1, 1) && getMark(1, 1) == getMark(2, 1) && getMark(0, 1) != null) {return getMark(0, 1);} // Vertical Check
		if(getMark(0, 2) == getMark(1, 2) && getMark(2, 2) == getMark(0, 2) && getMark(0, 2) != null) {return getMark(0, 0);} // Vertical Check
		
		if(getMark(0, 0) == getMark(1, 1) && getMark(0, 0) == getMark(2, 2) && getMark(0, 0) != null) {return getMark(0, 0);} // Diagonal Check
		if(getMark(0, 2) == getMark(1, 1) && getMark(0, 2) == getMark(2, 0) && getMark(0, 2) != null) {return getMark(0, 2);} // Diagonal Check
		
		return null;
	}
	
	public String toString() {
		String verticalDivider = "|";
		String horizontalDivider = "-----";
		String board = "";
		int al[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
		
		for(int h = 0; h < movesArray.length; h++) {
			
			if(movesArray[h] >= 0 && h % 2 == 0) {
				al[movesArray[h]] = 1;
			}
			if(movesArray[h] >= 0 && h % 2 == 1) {
				al[movesArray[h]] = 2;
			}
		}
		
		for (int k = 0; k < al.length; k++) {
			
			if (al[k] == -1) {board += " ";}
			else if (al[k] == 1) {board += "X";} 
			else if (al[k] == 2) {board += "O";}
			
			if (k == 2 || k == 5) {board += "\n"; board += horizontalDivider; board += "\n";}
			
			if (k == 0 || k == 1 || k == 3 || k == 4 || k == 6 || k == 7) {board += verticalDivider;}
		}
		board += "\n" + "\n";
		
		
		return board;
	}
	
	

	public boolean noEmptySpots() {
		
		int al[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
		
		for(int h = 0; h < movesArray.length; h++) {
			
			if(movesArray[h] >= 0 && h % 2 == 0) {
				al[movesArray[h]] = 1;
			}
			if(movesArray[h] >= 0 && h % 2 == 1) {
				al[movesArray[h]] = 2;
			}
		}
		
		for (int q = 0; q < al.length; q++) {if (al[q] == -1) {return false;}}
		return true;
		}
}

