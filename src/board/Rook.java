package board;


/**
 * This class represents a Rook
 * 
 * @author Evan Liu
 * @version 1
 */

public class Rook extends ChessPiece{
	
	/**
	 * whether or not this piece has moved
	 */
	public boolean moved;
	
	/**
	 * creates a Rook, a chess piece that can move up, down, left, or right however many spaces it wants,
	 * shows whether or not it's white, its output name, and whether or not it has moved
	 * 
	 * @param white whether it's a white piece or a black piece
	 * @param name output string that will be shown in the ascii art
	 * @param moved whether it has moved or not
	 */
	public Rook(boolean white, String name, boolean moved)
	{
		
		super(white, name);
		this.moved = moved;
	}
	
	/**
	 * This is a boolean method to check if the Rook can be moved from its initial spot to 
	 * the end spot that we're trying to get to. 
	 * 
	 * 
	 * 
	 * @param initial_col initial column that the Rook resides in
	 * @param initial_row initial row that the Rook resides in
	 * @param end_col column that we're trying to move the Bishop to
	 * @param end_row row that we're trying to move the Bishop to
	 * @param board the 2D array of Rook pieces that contains the Knight
	 * @param o the actual Pawn object in the 2D array
	 * @return whether or not the move from [initial_row][initial_col] to [end_row][end_col] can be executed
	 */
	
	public static boolean isValidMove(int initial_col, int initial_row, int end_col, int end_row, ChessPiece[][] board, Rook o)
	{
		if(initial_col == end_col || initial_row == end_row)
		{
			if(initial_col == end_col && end_row > initial_row) //down
			{
				int init_row = initial_row+1;
				
				while(end_row > init_row )
				{
					if(!isEmptySpace(board, init_row, initial_col))
					{
						return false;
					}
					
					init_row++;
				}
				
				if(!isEmptySpace(board, end_row, end_col) && !o.isOppositeColor(board, end_row, end_col))
				{
					return false;
				}
				
				o.moved = true;
				return true;
			}
			else if(initial_col == end_col && end_row < initial_row) //up
			{
				int init_row = initial_row-1;
				
				while(end_row < init_row )
				{
					if(!isEmptySpace(board, init_row, initial_col))
					{
						return false;
					}
					
					init_row--;
				}
				
				if(!isEmptySpace(board, end_row, end_col) && !o.isOppositeColor(board, end_row, end_col))
				{
					return false;
				}
				
				o.moved = true;
				return true;
			}
			else if(end_row == initial_row && initial_col > end_col) //left
			{
				int init_col = initial_col - 1;
				
				while(end_col < init_col )
				{
					if(!isEmptySpace(board, init_col, initial_col))
					{
						return false;
					}
					
					init_col--;
				}
				
				if(!isEmptySpace(board, end_row, end_col) && !o.isOppositeColor(board, end_row, end_col))
				{
					return false;
				}
				
				o.moved = true;
				return true;
				
			}
			else if(end_row == initial_row && initial_col < end_col) //right
			{
				int init_col = initial_col+1;
				
				while(end_col > init_col )
				{
					if(!isEmptySpace(board, end_row, init_col))
					{
						return false;
					}
					
					init_col++;
				}
				
				if(!isEmptySpace(board, end_row, end_col) && !o.isOppositeColor(board, end_row, end_col))
				{
					return false;
				}
				
				o.moved = true;
				return true;
			}
			
		}
		
		return false;
	}
	

	/**
	 * 
	 * Checking is there's any rooks in any direction to put us in check at this specific position
	 * 
	 * @param row row we're checking check for
	 * @param col column we're checking check for
	 * @param board 2D array of chesspieces
	 * @param o the King object or the object that is being attacked
	 * @return if there's a rook that is attacking the king or the specified spot
	 */
	public static boolean Check(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		int temp_row = row-1;
		int temp_col = col;
		
		while(inBounds(board, temp_row, temp_col)) //going up
		{
			
			if(isEmptySpace(board, temp_row, temp_col))
			{
				temp_row--;
				continue;
			}
			else if(o.isOppositeColor(board, temp_row, temp_col) && (board[temp_row][temp_col] instanceof Rook || board[temp_row][temp_col] instanceof Queen))
			{
				return true;
			}
			else if(!o.isOppositeColor(board, temp_row, temp_col) || (o.isOppositeColor(board, temp_row, temp_col) && !(board[temp_row][temp_col] instanceof Rook || board[temp_row][temp_col] instanceof Queen)))
			{
				break;
			}
			
			temp_row--;
			
		}
		
		temp_row = row+1;
		
		while(inBounds(board, temp_row, temp_col)) //going down
		{
			if(isEmptySpace(board, temp_row, temp_col))
			{
				temp_row++;
				continue;
			}
			else if(o.isOppositeColor(board, temp_row, temp_col) && (board[temp_row][temp_col] instanceof Rook || board[temp_row][temp_col] instanceof Queen))
			{
				return true;
			}
			else if(!o.isOppositeColor(board, temp_row, temp_col) || (o.isOppositeColor(board, temp_row, temp_col) && !(board[temp_row][temp_col] instanceof Rook || board[temp_row][temp_col] instanceof Queen)))
			{
				break;
			}
			
			temp_row++;
		}
		
		temp_row = row;
		temp_col++;
		
		while(inBounds(board, temp_row, temp_col)) //going right
		{
			if(isEmptySpace(board, temp_row, temp_col))
			{
				temp_col++;
				continue;
			}
			else if(o.isOppositeColor(board, temp_row, temp_col) && (board[temp_row][temp_col] instanceof Rook || board[temp_row][temp_col] instanceof Queen))
			{
				return true;
			}
			else if(!o.isOppositeColor(board, temp_row, temp_col) || (o.isOppositeColor(board, temp_row, temp_col) && !(board[temp_row][temp_col] instanceof Rook || board[temp_row][temp_col] instanceof Queen)))
			{
				break;
			}
			
			temp_col++;
		}
		
		temp_col = col -1;
		
		while(inBounds(board, temp_row, temp_col)) //going left
		{
			if(isEmptySpace(board, temp_row, temp_col))
			{
				temp_col--;
				continue;
			}
			else if(o.isOppositeColor(board, temp_row, temp_col) && (board[temp_row][temp_col] instanceof Rook || board[temp_row][temp_col] instanceof Queen))
			{
				return true;
			}
			else if(!o.isOppositeColor(board, temp_row, temp_col) || (o.isOppositeColor(board, temp_row, temp_col) && !(board[temp_row][temp_col] instanceof Rook || board[temp_row][temp_col] instanceof Queen)))
			{
				break;
			}
			
			temp_col--;
		}
		
		return false;
	}

}
