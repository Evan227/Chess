package board;

/**
 * This class represents a Bishop
 * 
 * @author Evan Liu
 * @version 1
 */


public class Bishop extends ChessPiece{
	
	
	/**
	 * 
	 * Creates a Bishop, a chess piece that can only be moved diagonally, with output String and whether
	 * it's white or not
	 * 
	 * @param white whether it's a white piece or a black piece
	 * @param name output string that will be shown in the ascii art
	 */
	
	public Bishop(boolean white, String name)
	{
		super(white, name);
	}
	
	/**
	 * This is a boolean method to check if the Bishop can be moved from its initial spot to 
	 * the end spot that we're trying to get to. It checks various things such as if anythings in the way
	 * and also if there's a piece in the end spot that is indeed the opposite color of the Bishop
	 * so we can determine if we can capture it
	 * 
	 * @param initial_col initial column that the Bishop resides in
	 * @param initial_row initial row that the Bishop resides in
	 * @param end_col column that we're trying to move the Bishop to
	 * @param end_row row that we're trying to move the Bishop to
	 * @param board the 2D array of Chess pieces that contains the Bishop
	 * @param o the actual Bishop object in the 2D array
	 * @return whether or not the move from [initial_row][initial_col] to [end_row][end_col] can be executed
	 */
	
	public static boolean isValidMove(int initial_col, int initial_row, int end_col, int end_row, ChessPiece[][] board, ChessPiece o)
	{
		if(Math.abs(initial_row - end_row) == Math.abs(initial_col - end_col)) //basically if diagonal move
		{
			if(end_row > initial_row && end_col > initial_col) //lower righthand diagonal move
			{
				int init_row = initial_row+1;
				int init_col = initial_col+1;
				
				while(end_row > init_row && end_col > init_col)
				{
					if(!isEmptySpace(board, init_row, init_col))
					{
						return false;
					}
					
					init_row++;
					init_col++;
				}
				
				if(!isEmptySpace(board, end_row, end_col) && !o.isOppositeColor(board, end_row, end_col))
				{
					return false;
				}
				
				return true;
			}
			else if(end_row < initial_row && end_col > initial_col) //upper righthand diagonal move
			{
				int init_row = initial_row-1;
				int init_col = initial_col+1;
				
				while(end_row < init_row && end_col > init_col)
				{
					if(!isEmptySpace(board, init_row, init_col))
					{
						return false;
					}
					
					init_row--;
					init_col++;
				}
				
				if(!isEmptySpace(board, end_row, end_col) && !o.isOppositeColor(board, end_row, end_col))
				{
					return false;
				}
				
				return true;
			}
			else if(end_row > initial_row && end_col < initial_col)//lower lefthand diagonal move
			{
				int init_row = initial_row+1;
				int init_col = initial_col-1;
				
				while(end_row > init_row && end_col < init_col)
				{
					if(!isEmptySpace(board, init_row, init_col))
					{
						return false;
					}
					
					init_row++;
					init_col--;
				}
				
				if(!isEmptySpace(board, end_row, end_col) && !o.isOppositeColor(board, end_row, end_col))
				{
					return false;
				}
				
				return true;
			}
			else if(end_row < initial_row && end_col < initial_col) //upper lefthand diagonal move
			{
				int init_row = initial_row-1;
				int init_col = initial_col-1;
				
				while(end_row < init_row && end_col < init_col)
				{
					if(!isEmptySpace(board, init_row, init_col))
					{
						return false;
					}
					
					init_row--;
					init_col--;
				}
				
				if(!isEmptySpace(board, end_row, end_col) && !o.isOppositeColor(board, end_row, end_col))
				{
					return false;
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Determines if there's a bishop attacking the king or the specified spot
	 * 
	 * @param row row we're checking to see if a bishop is attacking it
	 * @param col column we're checking to see if a bishop is attacking it
	 * @param board 2D array to simulate a chessboard
	 * @param o the King object or the object being attacked
	 * @return whether or not there's a bishop that is attacking this specific space
	 */
	
	public static boolean Check(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		int temp_row = row-1;
		int temp_col = col+1;
		
		while(inBounds(board, temp_row, temp_col)) //going upper right
		{
			
			if(isEmptySpace(board, temp_row, temp_col))
			{
				temp_row--;
				temp_col++;
				continue;
			}
			else if(o.isOppositeColor(board, temp_row, temp_col) && (board[temp_row][temp_col] instanceof Bishop || board[temp_row][temp_col] instanceof Queen))
			{
				return true;
			}
			else if(!o.isOppositeColor(board, temp_row, temp_col) || (o.isOppositeColor(board, temp_row, temp_col) && !(board[temp_row][temp_col] instanceof Bishop || board[temp_row][temp_col] instanceof Queen)))
			{
				break;
			}
			
			temp_row--;
			temp_col++;
			
		}
		
		temp_row = row-1;
		temp_col = col-1;
		
		while(inBounds(board, temp_row, temp_col)) //going upper left
		{
			if(isEmptySpace(board, temp_row, temp_col))
			{
				temp_row--;
				temp_col--;
				continue;
			}
			else if(o.isOppositeColor(board, temp_row, temp_col) && (board[temp_row][temp_col] instanceof Bishop || board[temp_row][temp_col] instanceof Queen))
			{
				return true;
			}
			else if(!o.isOppositeColor(board, temp_row, temp_col) || (o.isOppositeColor(board, temp_row, temp_col) && !(board[temp_row][temp_col] instanceof Bishop || board[temp_row][temp_col] instanceof Queen)))
			{
				break;
			}
			
			temp_row--;
			temp_col--;
		}
		
		temp_row = row + 1;
		temp_col = col - 1;
		
		while(inBounds(board, temp_row, temp_col)) //going lower left
		{
			if(isEmptySpace(board, temp_row, temp_col))
			{
				temp_row ++;
				temp_col--;
				continue;
			}
			else if(o.isOppositeColor(board, temp_row, temp_col) && (board[temp_row][temp_col] instanceof Bishop || board[temp_row][temp_col] instanceof Queen))
			{
				return true;
			}
			else if(!o.isOppositeColor(board, temp_row, temp_col) || (o.isOppositeColor(board, temp_row, temp_col) && !(board[temp_row][temp_col] instanceof Bishop || board[temp_row][temp_col] instanceof Queen)))
			{
				break;
			}
			
			temp_row++;
			temp_col--;
		}
		
		temp_row = row+1;
		temp_col = col +1;
		
		while(inBounds(board, temp_row, temp_col)) //going lower right
		{
			if(isEmptySpace(board, temp_row, temp_col))
			{
				temp_row++;
				temp_col++;
				continue;
			}
			else if(o.isOppositeColor(board, temp_row, temp_col) && (board[temp_row][temp_col] instanceof Bishop || board[temp_row][temp_col] instanceof Queen))
			{
				return true;
			}
			else if(!o.isOppositeColor(board, temp_row, temp_col) || (o.isOppositeColor(board, temp_row, temp_col) && !(board[temp_row][temp_col] instanceof Bishop || board[temp_row][temp_col] instanceof Queen)))
			{
				break;
			}
			
			temp_row++;
			temp_col++;
		}
		
		return false;
	}

}
