package board;

/**
 * This class implements a Knight, chess piece that can only move 2 spaces in one direction and 1 space
 * that is perpendicular to the aforementioned direction
 * 
 * @author Evan Liu
 * @version 1
 */

public class Knight extends ChessPiece{
	
	
	/**
	 * creates a Knight, a chess piece that can only move 2 spaces in one direction and 1 space
	 * that is perpendicular to the aforementioned direction
	 * 
	 * @param white whether it's a white piece or a black piece
	 * @param name output string that will be shown in the ascii art
	 */
	public Knight(boolean white, String name)
	{
		super(white, name);
	}
	
	/**
	 * This is a boolean method to check if the Knight can be moved from its initial spot to 
	 * the end spot that we're trying to get to. 
	 * 
	 * 
	 * 
	 * @param initial_col initial column that the Knight resides in
	 * @param initial_row initial row that the Knight resides in
	 * @param end_col column that we're trying to move the Bishop to
	 * @param end_row row that we're trying to move the Bishop to
	 * @param board the 2D array of Chess pieces that contains the Knight
	 * @param o the actual King object in the 2D array
	 * @return whether or not the move from [initial_row][initial_col] to [end_row][end_col] can be executed
	 */
	
	public static boolean isValidMove(int initial_col, int initial_row, int end_col, int end_row, ChessPiece[][] board, ChessPiece o)
	{
		if(inBounds(board, initial_row -2, initial_col+1) && end_row == initial_row-2 && end_col == initial_col+1) // 2 up, 1 right
		{
			if(board[initial_row-2][initial_col+1] != null && o.isOppositeColor(board, initial_row-2, initial_col+1))
			{
				return true;
			}
			else if(board[initial_row-2][initial_col+1] == null)
			{
				return true;
			}
		}
		else if(inBounds(board, initial_row -2, initial_col-1) && end_row == initial_row-2 && end_col == initial_col-1) // 2 up, 1 left
		{
			if(board[initial_row-2][initial_col-1] != null && o.isOppositeColor(board, initial_row-2, initial_col-1))
			{
				return true;
			}
			else if(board[initial_row-2][initial_col-1] == null)
			{
				return true;
			}
		}
		else if(inBounds(board, initial_row-1, initial_col +2 ) && end_row  == initial_row-1 && end_col == initial_col + 2) // 2 right,1 up
		{
			if(board[initial_row-1][initial_col+2] != null && o.isOppositeColor(board, initial_row-1, initial_col+2))
			{
				return true;
			}
			else if(board[initial_row-1][initial_col+2] == null)
			{
				return true;
			}
		}
		else if(inBounds(board, initial_row+1, initial_col +2 ) && end_row  == initial_row+1 && end_col == initial_col + 2) // 2 right,1 down
		{
			if(board[initial_row+1][initial_col+2] != null && o.isOppositeColor(board, initial_row+1, initial_col+2))
			{
				return true;
			}
			else if(board[initial_row+1][initial_col+2] == null)
			{
				return true;
			}
		}
		else if(inBounds(board, initial_row +2, initial_col+1) && end_row == initial_row+2 && end_col == initial_col+1) // 2 down, 1 right
		{
			if(board[initial_row+2][initial_col+1] != null && o.isOppositeColor(board, initial_row+2, initial_col+1))
			{
				return true;
			}
			else if(board[initial_row+2][initial_col+1] == null)
			{
				return true;
			}
		}
		else if(inBounds(board, initial_row +2, initial_col-1) && end_row == initial_row+2 && end_col == initial_col-1) // 2 down, 1 left
		{
			if(board[initial_row+2][initial_col-1] != null && o.isOppositeColor(board, initial_row+2, initial_col-1))
			{
				return true;
			}
			else if(board[initial_row+2][initial_col-1] == null)
			{
				return true;
			}
		}
		else if(inBounds(board, initial_row +1, initial_col-2) && end_row == initial_row+1 && end_col == initial_col-2) // 2 left, 1 down
		{
			if(board[initial_row+1][initial_col-2] != null && o.isOppositeColor(board, initial_row+1, initial_col-2))
			{
				return true;
			}
			else if(board[initial_row+1][initial_col-2] == null)
			{
				return true;
			}
		}
		else if(inBounds(board, initial_row -1, initial_col-2) && end_row == initial_row-1 && end_col == initial_col-2) // 2 left, 1 up
		{
			if(board[initial_row-1][initial_col-2] != null && o.isOppositeColor(board, initial_row-1, initial_col-2))
			{
				return true;
			}
			else if(board[initial_row-1][initial_col-2] == null)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * determines if the specific space in [row][col] is being under attack by a knight
	 * 
	 * @param row row the ChessPiece o is attacking
	 * @param col col the ChessPiece o is attacking
	 * @param board 2D array of chessPieces 
	 * @param o the object that is attacking [row][col]
	 * @return whether or not the specific space is being attacked by a knight
	 */
	
	public static boolean Check(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		//2 up, 1 right
		if(inBounds(board, row-2, col+1) && !isEmptySpace(board, row-2, col+1) && o.white && o.isOppositeColor(board, row-2, col+1) &&  board[row-2][col+1] instanceof Knight)
		{
			return true;
		}
		//2 up, 1 left
		else if(inBounds(board, row-2, col-1) && !isEmptySpace(board, row-2, col-1) && o.white && o.isOppositeColor(board, row-2, col-1) &&  board[row-2][col-1] instanceof Knight)
		{
			return true;
		}
		//2 left, 1 up
		else if(inBounds(board, row-1, col-2) && !isEmptySpace(board, row-1, col-2) && o.white && o.isOppositeColor(board, row-1, col-2) &&  board[row-1][col-2] instanceof Knight)
		{
			return true;
		}
		//2 left, 1 down
		else if(inBounds(board, row+1, col-2) && !isEmptySpace(board, row+1, col-2) && o.white && o.isOppositeColor(board, row+1, col-2) &&  board[row+1][col-2] instanceof Knight)
		{
			return true;
		}
		//2 down, 1 left
		else if(inBounds(board, row+2, col-1) && !isEmptySpace(board, row+2, col-1) && o.white && o.isOppositeColor(board, row+2, col-1) &&  board[row+2][col-1] instanceof Knight)
		{
			return true;
		}
		//2 down, 1 right
		else if(inBounds(board, row+2, col+1) && !isEmptySpace(board, row+1, col+1) && o.white && o.isOppositeColor(board, row+2, col+1) &&  board[row+2][col+1] instanceof Knight)
		{
			return true;
		}
		//2 right, 1 up
		else if(inBounds(board, row-1, col+2) && !isEmptySpace(board, row-1, col+2) && o.white && o.isOppositeColor(board, row-1, col+2) &&  board[row-1][col+2] instanceof Knight)
		{
			return true;
		}
		//2 right, 1 down
		else if(inBounds(board, row+1, col+2) && !isEmptySpace(board, row+1, col+2) && o.white && o.isOppositeColor(board, row+1, col+2) &&  board[row+1][col+2] instanceof Knight)
		{
			return true;
		}		
		
		return false;
	}

}
