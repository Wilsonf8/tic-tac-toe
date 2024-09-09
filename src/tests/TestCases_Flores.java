package tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import tictactoe.Mark;
import tictactoe.TicTacToeBoard;
import tictactoe.TicTacToeBoardImpl_Flores;

public class TestCases_Flores {

	@Test(timeout=3000)
	public void markTests(){	
		
		TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
		
		board.setMark(0, 0);
		assertEquals(Mark.X, board.getMark(0, 0));
		
		board.setMark(1, 0);
		assertEquals(Mark.O, board.getMark(1, 0));
		
		board.setMark(2, 0);
		assertEquals(Mark.X, board.getMark(2, 0));
		
		board.setMark(0, 1);
		assertEquals(Mark.O, board.getMark(0, 1));
		
		board.setMark(1, 1);
		assertEquals(Mark.X, board.getMark(1, 1));
		
		board.setMark(2, 1);
		assertEquals(Mark.O, board.getMark(2, 1));
		
		board.setMark(0, 2);
		assertEquals(Mark.X, board.getMark(0, 2));
		
		
		assertEquals(null, board.getMark(2, 2));
		
		
		assertEquals(true, board.isGameOver());
		assertEquals(Mark.X, board.getWinner());
	}	
	
	@Test(timeout=3000)
	public void setMarkAssert(){	
		
		TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
		
		board.setMark(0, 2);
		board.setMark(1, 2);
		board.setMark(2, 2);
		board.setMark(0, 1);
		board.setMark(1, 0);
		board.setMark(1, 1);
		assertThrows(AssertionError.class, () -> board.setMark(0, 1)); // testing for if getMark != null
		assertThrows(AssertionError.class, () -> board.setMark(0, 3));
		assertThrows(AssertionError.class, () -> board.setMark(0, -1));
		assertThrows(AssertionError.class, () -> board.setMark(-3, 2));
		assertThrows(AssertionError.class, () -> board.setMark(5, 0));
		board.setMark(2, 1);
//		System.out.println(board.toString());
		board.setMark(0, 0);
		board.setMark(2, 0);
//		System.out.println(board.toString());
		assertThrows(AssertionError.class, () -> board.setMark(1, 0));
		assertThrows(AssertionError.class, () -> board.setMark(1, 0));
		assertEquals(true, board.isGameOver());
		
		
	}	
	
	@Test(timeout=3000)
	public void setMarkWithWinner(){	
		
		TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
		
		board.setMark(0, 2);
		board.setMark(1, 2);
		board.setMark(0, 1);
		board.setMark(2, 2);
		board.setMark(0, 0);
		assertEquals(true, board.isGameOver());
//		System.out.println(board.toString());
		assertThrows(AssertionError.class, () -> board.setMark(2, 0));
		
		
	}
	
	@Test(timeout=3000)
	public void getMarkAssert(){	
		
		TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
		
		assertThrows(AssertionError.class, () -> board.getMark(4, 0));
		assertThrows(AssertionError.class, () -> board.getMark(-1, 0));
		assertThrows(AssertionError.class, () -> board.getMark(1, -3));
		assertThrows(AssertionError.class, () -> board.getMark(2, 7));
		assertEquals(null, board.getMark(0, 0));
		
		
	}	
	
	@Test(timeout=3000)
	public void DiagonalTests(){	
		
		TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
		
		board.setMark(0, 0);
		board.setMark(1, 0);
		board.setMark(1, 1);
		board.setMark(0, 1);
		board.setMark(2, 2);
//		System.out.println(board.toString());
		assertEquals(true, board.isGameOver());
		assertEquals(Mark.X, board.getWinner());
	}	
	
	@Test(timeout=3000)
	public void DiagonalTests2(){	
		
		TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
		
		board.setMark(1, 2);
		board.setMark(0, 2);
		board.setMark(2, 1);
		board.setMark(1, 1);
		board.setMark(2, 2);
		board.setMark(2, 0);
//		System.out.println(board.toString());
		assertEquals(true, board.isGameOver());
		assertEquals(Mark.O, board.getWinner());	
		
	}
	
	@Test(timeout=3000)
	public void TieTests() {
		
		TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
		
		board.setMark(0, 0);
		board.setMark(0, 1);
		board.setMark(0, 2);
		board.setMark(1, 1);
		board.setMark(1, 0);
		board.setMark(2, 0);
		board.setMark(2, 1);
		board.setMark(1, 2);
		board.setMark(2, 2);
		
//		System.out.println(board.toString());
		
		assertEquals(true, board.isGameOver());
		assertEquals(null, board.getWinner());
		
	}
	
	@Test(expected=AssertionError.class)
	public void assertionTestInGetWinner() {
		
		TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
		
		board.setMark(2, 1);
		board.setMark(1, 2);
		board.setMark(2, 2);
		
		assertEquals(false, board.isGameOver());
		board.getWinner();
		
	}
	
	@Test(timeout=3000)
	public void getTurnTests(){	
		
		TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
		
		assertEquals(false, board.isGameOver());
		
		assertEquals(Mark.X, board.getTurn());
		board.setMark(0, 0);
		assertEquals(Mark.X, board.getMark(0, 0));
		
		assertEquals(Mark.O, board.getTurn());
		board.setMark(2, 2);
		assertEquals(Mark.O, board.getMark(2, 2));
		
		assertEquals(Mark.X, board.getTurn());
		board.setMark(0, 2);
		assertEquals(Mark.X, board.getMark(0, 2));
		
		assertEquals(Mark.O, board.getTurn());
		board.setMark(2, 0);
		assertEquals(Mark.O, board.getMark(2, 0));
		
		assertEquals(Mark.X, board.getTurn());
		board.setMark(2, 1);
		assertEquals(Mark.X, board.getMark(2, 1));
		
		assertEquals(Mark.O, board.getTurn());
		board.setMark(0, 1);
		assertEquals(Mark.O, board.getMark(0, 1));
		
		assertEquals(Mark.X, board.getTurn());
		board.setMark(1, 1);
		assertEquals(Mark.X, board.getMark(1, 1));
		
		assertEquals(Mark.O, board.getTurn());
		board.setMark(1, 0);
		assertEquals(Mark.O, board.getMark(1, 0));
		
		assertEquals(Mark.X, board.getTurn());
		board.setMark(1, 2);
		assertEquals(Mark.X, board.getMark(1, 2));
		
		assertEquals(true, board.isGameOver());
		assertEquals(null, board.getWinner());
		
		
		System.out.println(board.toString());
		
		
		
	}
	
	@Test
    public void testHorizontalWin() 
    
    {
    
    	TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
        studentBoard.setMark(0, 2);
        studentBoard.setMark(1, 1);
        studentBoard.setMark(0, 1);
        studentBoard.setMark(1, 0);
        studentBoard.setMark(2, 2); // Player X wins horizontally
        studentBoard.setMark(1, 2);
        assertEquals(Mark.O, studentBoard.getWinner());
        
    }

    @Test
    public void testVerticalWin() 
    
    {
    
    	TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
        studentBoard.setMark(2, 2);
        studentBoard.setMark(0, 1);
        studentBoard.setMark(1, 2);
        studentBoard.setMark(1, 1);
        studentBoard.setMark(2, 0);
        studentBoard.setMark(2, 1); // Player O wins vertically
        assertEquals(Mark.O, studentBoard.getWinner());
    
    }

    @Test
    public void testDiagonalWin() 
    
    {
        
    	TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
        studentBoard.setMark(2, 2);
        studentBoard.setMark(0, 0);
        studentBoard.setMark(1, 1);
        studentBoard.setMark(0, 1);
        studentBoard.setMark(0, 2);
        studentBoard.setMark(1, 2);
        studentBoard.setMark(2, 0); // Player X wins diagonally
        assertEquals(Mark.X, studentBoard.getWinner());
    
    }
    
    @Test
    public void testDiagonalWin2() 
    
    {
        
    	TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
                
        studentBoard.setMark(1, 0);
        studentBoard.setMark(2, 2);
        studentBoard.setMark(2, 0);
        studentBoard.setMark(1, 1);
        studentBoard.setMark(0, 2);
        studentBoard.setMark(0, 0);
        assertEquals(Mark.O, studentBoard.getWinner());
    
    }

    @Test
    public void testGameNotOver() 
    
    {
        
    	TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
        studentBoard.setMark(1, 0);
        studentBoard.setMark(1, 1);
        studentBoard.setMark(2, 1);
        assertFalse(studentBoard.isGameOver());
    
    }

    @Test
    public void testGameEndsInTie() 
    
    {
        
    	TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
        studentBoard.setMark(0, 0);
        studentBoard.setMark(0, 1);
        studentBoard.setMark(0, 2);
        studentBoard.setMark(1, 0);
        studentBoard.setMark(1, 2);
        studentBoard.setMark(1, 1);
        studentBoard.setMark(2, 0);
        studentBoard.setMark(2, 2);
        studentBoard.setMark(2, 1); // Game ends in a tie
        assertTrue(studentBoard.isGameOver());
        assertNull(studentBoard.getWinner());
    
    }
    
    @Test
    public void testSetMarkDoesNotEqualAnotherMark()
    
    {
        
    	TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
        studentBoard.setMark(0, 0);
        
        assertThrows(AssertionError.class, () -> {
            studentBoard.setMark(0, 0);
        });
 
    }
    
	
	@Test
	public void setMark() 
	
	{
		
		//Fields
		TicTacToeBoardImpl_Flores boardImpl = new TicTacToeBoardImpl_Flores();
		Mark expected;
		Mark actual;
				
		//Move 1
		expected = Mark.X;
		boardImpl.setMark(0, 1);
		actual = boardImpl.getMark(0, 1);
		assertEquals("setMark_1 -> ", expected, actual);
		
		//Move 2
		expected = Mark.O;
		boardImpl.setMark(1, 2);
		actual = boardImpl.getMark(1, 2);
		assertEquals("setMark_2 -> ", expected, actual);
		
		//Move 3
		expected = Mark.X;
		boardImpl.setMark(2, 1);
		actual = boardImpl.getMark(2, 1);
		assertEquals("setMark_3 -> ", expected, actual);
				
		//Throwing an assertion if we add another play at the same location
		assertThrows(AssertionError.class, () -> {
	        boardImpl.setMark(2, 1);
	    });
			
	}
	
	@Test
    public void testGameAfterWinningMove() 
	
	{
        TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
        studentBoard.setMark(0, 0);
        studentBoard.setMark(1, 0);
        studentBoard.setMark(0, 1);
        studentBoard.setMark(1, 1);
        studentBoard.setMark(0, 2); // Player X wins horizontally
        assertTrue(studentBoard.isGameOver());
        assertEquals(Mark.X, studentBoard.getWinner());
    
	}

    @Test
    public void testGameAfterTie() 
    
    {
        TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
        studentBoard.setMark(0, 0);
        studentBoard.setMark(0, 1);
        studentBoard.setMark(0, 2);
        studentBoard.setMark(1, 0);
        studentBoard.setMark(1, 2);
        studentBoard.setMark(1, 1);
        studentBoard.setMark(2, 0);
        studentBoard.setMark(2, 2);
        studentBoard.setMark(2, 1); // Game ends in a tie
        assertTrue(studentBoard.isGameOver());
        assertNull(studentBoard.getWinner());
    
    }

    @Test
    public void testGetMarkOutOfBounds() 
    
    {
        TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
        assertThrows(AssertionError.class, () -> {studentBoard.getMark(3, 3);});
    
    }

    @Test
    public void testSetMarkOutOfBounds() 
    
    {
        TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
        assertThrows(AssertionError.class, () -> {
            studentBoard.setMark(3, 3);
        });
    
    }

    @Test
    public void testGameNotOverAfterIncompleteMove() 
    
    {
        TicTacToeBoard studentBoard = new TicTacToeBoardImpl_Flores();
        studentBoard.setMark(0, 0);
        studentBoard.setMark(1, 0);
        studentBoard.setMark(0, 1);
        studentBoard.setMark(1, 1);
        studentBoard.setMark(0, 2);
        assertThrows(AssertionError.class, () -> studentBoard.setMark(1, 2)); // Setting mark on an already marked cell
        System.out.print(studentBoard.toString());
        
    
    }

    @Test
    public void testSetMarkAndGetMark() {
        TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
        board.setMark(1, 1);
        assertEquals(Mark.X, board.getMark(1, 1));
        assertNull(board.getMark(0, 0));
        assertNull(board.getMark(2, 2));
    }

    @Test
    public void testInvalidMove() {
        TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
        board.setMark(1, 1);
        assertThrows(AssertionError.class, () -> board.setMark(1, 1)); // Setting mark on an already marked cell
        assertThrows(AssertionError.class, () -> board.setMark(-1, 1)); // Setting mark with invalid row
        assertThrows(AssertionError.class, () -> board.setMark(1, 3));  // Setting mark with invalid column
    }

    @Test
    public void testGameInProgress() {
        TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
        board.setMark(0, 0);
        board.setMark(1, 1);
        board.setMark(2, 2);
//        assertNull(board.getWinner());
        assertNotNull(board.getTurn());
        assertFalse(board.isGameOver());
    }

    @Test
    public void testHorizontalWin2() {
        TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
        board.setMark(0, 0); // X
        board.setMark(1, 0); // O
        board.setMark(0, 1); // X
        board.setMark(1, 1); // O
        board.setMark(0, 2); // X
        assertEquals(Mark.X, board.getWinner());
        assertTrue(board.isGameOver());
    }

    @Test
    public void testVerticalWin2() {
        TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
        board.setMark(0, 0); // X
        board.setMark(0, 1); // O
        board.setMark(1, 0); // X
        board.setMark(1, 1); // O
        board.setMark(2, 0); // X
        assertEquals(Mark.X, board.getWinner());
        assertTrue(board.isGameOver());
    }

    @Test
    public void testDiagonalWin3() {
        TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
        board.setMark(0, 0); // X
        board.setMark(0, 2); // O
        board.setMark(1, 1); // X
        board.setMark(1, 2); // O
        board.setMark(2, 2); // X
        assertEquals(Mark.X, board.getWinner());
        assertTrue(board.isGameOver());
    }

    @Test
    public void testAntiDiagonalWin() {
        TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
        board.setMark(0, 2); // X
        board.setMark(0, 0); // O
        board.setMark(1, 1); // X
        board.setMark(1, 2); // O
        board.setMark(2, 0); // X
        assertEquals(Mark.X, board.getWinner());
        assertTrue(board.isGameOver());
    }

    @Test
    public  void testTieGame() {
        TicTacToeBoard board = new TicTacToeBoardImpl_Flores();
        board.setMark(0, 0);
        board.setMark(0, 1);
        board.setMark(0, 2);
        board.setMark(1, 1);
        board.setMark(1, 0);
        board.setMark(1, 2);
        board.setMark(2, 1);
        board.setMark(2, 0);
        board.setMark(2, 2);
        assertNull(board.getWinner());
        assertTrue(board.isGameOver());
    }
    
    

}