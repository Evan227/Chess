package board;

/**
 * This class represents a King, a chess piece that can move in any direction but only one space
 * 
 * @author Evan Liu
 * @version 1
 */

public class King extends ChessPiece{
	
	/**
	 * whether or not the King has moved or not
	 */
	public boolean moved;
	
	/**
	 * creates a king, a chess piece that can move in any direction but only one space
	 * 
	 * @param white whether it's a white piece or a black piece
	 * @param name output string that will be shown in the ascii art
	 * @param moved whether it has moved or not
	 */
	public King(boolean white, String name, boolean moved)
	{
		super(white, name);
		this.moved = moved;
	}
	
	
	/**
	 * This is a boolean method to check if the King can be moved from its initial spot to 
	 * the end spot that we're trying to get to. 
	 * 
	 * 
	 * 
	 * @param initial_col initial column that the King resides in
	 * @param initial_row initial row that the King resides in
	 * @param end_col column that we're trying to move the Bishop to
	 * @param end_row row that we're trying to move the Bishop to
	 * @param board the 2D array of Chess pieces that contains the King
	 * @param o the actual King object in the 2D array
	 * @return whether or not the move from [initial_row][initial_col] to [end_row][end_col] can be executed
	 */
	
	public static boolean isValidMove(int initial_col, int initial_row, int end_col, int end_row, ChessPiece[][] board, King o)
	{
		if(inBounds(board, initial_row -1, initial_col) && end_row + 1 == initial_row && end_col == initial_col) // up
		{
			if(board[initial_row-1][initial_col] != null && o.isOppositeColor(board, initial_row-1, initial_col) && !Check(initial_row-1, initial_col, board, (King)o))
			{
				o.moved = true;
				return true;
			}
			else if(board[initial_row-1][initial_col] == null && !Check(initial_row-1, initial_col, board, (King)o))
			{
				o.moved = true;
				return true;
			}
		}
		else if(inBounds(board, initial_row + 1, initial_col) && end_row - 1 == initial_row && end_col == initial_col) // down
		{
			if(board[initial_row+1][initial_col] != null && o.isOppositeColor(board, initial_row+1, initial_col) && !Check(initial_row+1, initial_col, board, (King)o))
			{
				o.moved = true;
				return true;
			}
			else if(board[initial_row+1][initial_col] == null && !Check(initial_row+1, initial_col, board, (King)o))
			{
				o.moved = true;
				return true;
			}
		}
		else if(inBounds(board, initial_row, initial_col +1 ) && end_row  == initial_row && end_col == initial_col + 1) // right
		{
			if(board[initial_row][initial_col+1] != null && o.isOppositeColor(board, initial_row, initial_col+1) && !Check(initial_row, initial_col+1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
			else if(board[initial_row][initial_col+1] == null && !Check(initial_row, initial_col+1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
		}
		else if(inBounds(board, initial_row, initial_col-1) && end_row == initial_row && end_col == initial_col-1) // left
		{
			if(board[initial_row][initial_col-1] != null && o.isOppositeColor(board, initial_row, initial_col-1) && !Check(initial_row, initial_col-1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
			else if(board[initial_row][initial_col-1] == null && !Check(initial_row, initial_col-1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
		}
		else if(inBounds(board, initial_row -1, initial_col+1) && end_row == initial_row-1 && end_col == initial_col+1) // upper right
		{
			if(board[initial_row-1][initial_col+1] != null && o.isOppositeColor(board, initial_row-1, initial_col+1) && !Check(initial_row-1, initial_col+1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
			else if(board[initial_row-1][initial_col+1] == null && !Check(initial_row-1, initial_col+1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
		}
		else if(inBounds(board, initial_row +1, initial_col+1) && end_row  == initial_row+1 && end_col == initial_col+1) // lower right
		{
			if(board[initial_row+1][initial_col+1] != null && o.isOppositeColor(board, initial_row+1, initial_col+1) && !Check(initial_row+1, initial_col+1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
			else if(board[initial_row+1][initial_col+1] == null && !Check(initial_row+1, initial_col+1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
		}
		else if(inBounds(board, initial_row +1, initial_col-1) && end_row == initial_row+1 && end_col == initial_col-1) // lower left
		{
			if(board[initial_row+1][initial_col-1] != null && o.isOppositeColor(board, initial_row+1, initial_col-1) && !Check(initial_row+1, initial_col-1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
			else if(board[initial_row+1][initial_col-1] == null && !Check(initial_row+1, initial_col-1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
		}
		else if(inBounds(board, initial_row -1, initial_col-1) && end_row == initial_row-1 && end_col == initial_col-1) // upper left
		{
			if(board[initial_row-1][initial_col-1] != null && o.isOppositeColor(board, initial_row-1, initial_col-1) && !Check(initial_row-1, initial_col-1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
			else if(board[initial_row-1][initial_col-1] == null && !Check(initial_row-1, initial_col-1, board, (King)o))
			{
				o.moved = true;
				return true;
			}
		}
		else if(o.white == true && o.moved == false && board[7][5] == null && board[7][6]==null && end_row == 7 && end_col == 6)
		{
			if(board[7][7] instanceof Rook)
			{
				Rook hold = (Rook) board[7][7];
				
				if(!hold.moved)
				{
					board[7][7] = null;
					board[7][5] = hold;
					return true;
				}
			}
			
		}
		else if(o.white == false && o.moved == false && board[0][5] == null && board[0][6]==null && end_row == 0 && end_col == 6)
		{
			if(board[0][7] instanceof Rook)
			{
				Rook hold = (Rook) board[0][7];
				if(!hold.moved)
				{
					board[0][7] = null;
					board[0][5] = hold;
					return true;
				}
			}
		}
		else if(o.white == true && o.moved == false && board[7][3] == null && board[7][2]==null && board[7][1]==null &&  end_row == 7 && end_col == 2)
		{
			if(board[7][0] instanceof Rook)
			{
				Rook hold = (Rook) board[7][0];
				
				if(!hold.moved)
				{
					board[7][0] = null;
					board[7][3] = hold;
					return true;
				}
			}
			
		}
		else if(o.white == false && o.moved == false && board[0][1] == null && board[0][2]==null && board[0][3]==null && end_row == 0 && end_col == 2)
		{
			if(board[0][0] instanceof Rook)
			{
				Rook hold = (Rook) board[0][0];
				if(!hold.moved)
				{
					board[0][0] = null;
					board[0][3] = hold;
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * makes sure the resulting move doesn't result in 2 kings next to each other
	 * 
	 * @param row the row we're trying to move the piece into
	 * @param col the column we're trying to move the piece into
	 * @param board 2D array of ChessPieces to simulate a board
	 * @param o the piece we are trying to move
	 * @return whether or not the piece will be next to a king when we move it
	 */
	
	public static boolean kingCheck(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		//up
		if(inBounds(board, row-1, col) && !isEmptySpace(board, row-1, col) && o.isOppositeColor(board, row-1, col) &&  board[row-1][col] instanceof King)
		{
				return true;
		
		}
		//right
		else if(inBounds(board, row, col+1) && !isEmptySpace(board, row, col+1) && o.isOppositeColor(board, row, col+1) &&  board[row][col+1] instanceof King)
		{
				return true;
			
		}
		//down
		else if(inBounds(board, row+1, col)  && !isEmptySpace(board, row+1, col) && o.isOppositeColor(board, row+1, col) &&  board[row+1][col] instanceof King)
		{
				return true;
			
		}
		//left
		else if(inBounds(board, row, col-1)  && !isEmptySpace(board, row, col-1) && o.isOppositeColor(board, row, col-1) &&  board[row][col-1] instanceof King)
		{

				return true;
			
		}
		//upper right
		else if(inBounds(board, row-1, col+1)  && !isEmptySpace(board, row-1, col+1) && o.isOppositeColor(board, row-1, col+1) &&  board[row-1][col+1] instanceof King)
		{
				return true;
			
		}
		//lower right
		else if(inBounds(board, row+1, col+1)  && !isEmptySpace(board, row+1, col+1) && o.isOppositeColor(board, row+1, col+1) &&  board[row+1][col+1] instanceof King)
		{
				return true;
			
		}
		//lower left
		else if(inBounds(board, row+1, col-1)  && !isEmptySpace(board, row+1, col-1) && o.isOppositeColor(board, row+1, col-1) &&  board[row+1][col-1] instanceof King)
		{

				return true;
			
		}
		//upper left
		else if(inBounds(board, row-1, col-1)  && !isEmptySpace(board, row-1, col-1) && o.isOppositeColor(board, row-1, col-1) &&  board[row-1][col-1] instanceof King)
		{

				return true;
			
		}
		
		return false;
	}
	
	/**
	 * method to check if the King is being attacked by any piece, can also be used to decide
	 * if any piece can be captured
	 * 
	 * @param row row the King is in
	 * @param col column the King is in
	 * @param board 2D array of chess pieces that has the King
	 * @param o the King object
	 * @return if there's a piece directly attacking the ChessPiece parameter o
	 */
	
	public static boolean Check(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		if(o instanceof King)
		{
			//Pawn
			if(Pawn.Check(row, col, board, o))
			{
				return true;
			}
			//Rook, includes Queen
			else if(Rook.Check(row, col, board, o))
			{
				return true;
			}
			//Knight
			else if(Knight.Check(row, col, board, o))
			{
				return true;
			}
			//Bishop, includes Queen
			else if(Bishop.Check(row, col, board, o))
			{
				return true;
			}
			//King, kings aren't allowed to be next to each other
			else if(kingCheck(row, col, board, o))
			{
				return true;
			}
		}
		else 
		{
			//Pawn
			if(Pawn.Check(row, col, board, o))
			{
				return true;
			}
			//Rook, includes Queen
			else if(Rook.Check(row, col, board, o))
			{
				return true;
			}
			//Knight
			else if(Knight.Check(row, col, board, o))
			{
				return true;
			}
			//Bishop, includes Queen
			else if(Bishop.Check(row, col, board, o))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * utilized as the Check method but for the space above the specified piece
	 * 
	 * @param row row the King is in
	 * @param col column the King is in
	 * @param board 2D array of chess pieces that has the King
	 * @param o the King object
	 * @return if there's a piece directly attacking the space above the King
	 */
	
	public static boolean CheckUp(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		if(!inBounds(board, row-1, col))
		{
			return true;
		}
		else if(!isEmptySpace(board, row-1,col) && !board[row][col].isOppositeColor(board, row-1, col) )
		{
			return true;
		}
		
		return Check(row-1, col, board, o);
	}
	
	/**
	 * utilized as the Check method but for the space right of the specified piece
	 * 
	 * @param row row the King is in
	 * @param col column the King is in
	 * @param board 2D array of chess pieces that has the King
	 * @param o the King object
	 * @return if there's a piece directly attacking the space right to the King
	 */
	
	public static boolean CheckRight(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		if(!inBounds(board, row, col+1))
		{
			return true;
		}
		else if(!isEmptySpace(board, row,col+1) && !board[row][col].isOppositeColor(board, row, col+1))
		{
			return true;
		}
		
		return Check(row, col+1, board, o);
	}
	
	/**
	 * utilized as the Check method but for the space below the specified piece
	 * 
	 * @param row row the King is in
	 * @param col column the King is in
	 * @param board 2D array of chess pieces that has the King
	 * @param o the King object
	 * @return if there's a piece directly attacking the space below the King
	 */
	
	public static boolean CheckDown(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		if(!inBounds(board, row+1, col))
		{
			return true;
		}
		else if(!isEmptySpace(board, row+1,col) && !board[row][col].isOppositeColor(board, row+1, col) )
		{
			return true;
		}
		
		return Check(row+1, col, board, o);
	}
	
	/**
	 * utilized as the Check method but for the space left the specified piece
	 * 
	 * @param row row the King is in
	 * @param col column the King is in
	 * @param board 2D array of chess pieces that has the King
	 * @param o the King object
	 * @return if there's a piece directly attacking the space left to the King
	 */
	
	public static boolean CheckLeft(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		if(!inBounds(board, row, col-1))
		{
			return true;
		}
		else if(!isEmptySpace(board, row,col-1) && !board[row][col].isOppositeColor(board, row, col-1) )
		{
			return true;
		}
		
		return Check(row, col-1, board, o);
	}
	
	/**
	 * utilized as the Check method but for the space diagonally to the upper right of the specified piece
	 * 
	 * @param row row the King is in
	 * @param col column the King is in
	 * @param board 2D array of chess pieces that has the King
	 * @param o the King object
	 * @return if there's a piece directly attacking the space to the upper right of the King
	 */
	
	public static boolean CheckUpperRight(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		if(!inBounds(board, row-1, col+1))
		{
			return true;
		}
		else if(!isEmptySpace(board, row-1,col+1) && !board[row][col].isOppositeColor(board, row-1, col+1) )
		{
			return true;
		}
		
		return Check(row-1, col+1, board, o);
	}
	
	/**
	 * utilized as the Check method but for the space diagonally to the lower right of the specified piece
	 * 
	 * @param row row the King is in
	 * @param col column the King is in
	 * @param board 2D array of chess pieces that has the King
	 * @param o the King object
	 * @return if there's a piece directly attacking the space lower right of the King
	 */
	
	public static boolean CheckLowerRight(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		if(!inBounds(board, row+1, col+1))
		{
			return true;
		}
		else if(!isEmptySpace(board, row+1,col+1) && !board[row][col].isOppositeColor(board, row+1, col+1) )
		{
			return true;
		}
		
		return Check(row+1, col+1, board, o);
	}
	
	/**
	 * utilized as the Check method but for the space to the lower left of the specified piece
	 * 
	 * @param row row the King is in
	 * @param col column the King is in
	 * @param board 2D array of chess pieces that has the King
	 * @param o the King object
	 * @return if there's a piece directly attacking the space lower left of the King
	 */
	
	public static boolean CheckLowerLeft(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		if(!inBounds(board, row+1, col-1))
		{
			return true;
		}
		else if(!isEmptySpace(board, row+1,col-1) && !board[row][col].isOppositeColor(board, row+1, col-1) )
		{
			return true;
		}
		
		return Check(row+1, col-1, board, o);
	}
	
	/**
	 * utilized as the Check method but for the space to the upper left of the specified piece
	 * 
	 * @param row row the King is in
	 * @param col column the King is in
	 * @param board 2D array of chess pieces that has the King
	 * @param o the King object
	 * @return if there's a piece directly attacking the space upper left to the King
	 */
	
	public static boolean CheckUpperLeft(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		if(!inBounds(board, row-1, col-1))
		{
			return true;
		}
		else if(!isEmptySpace(board, row-1,col-1) && !board[row][col].isOppositeColor(board, row-1, col-1) )
		{
			return true;
		}
		
		return Check(row-1, col-1, board, o);
	}
	
	
	/**
	 * utilizes all above classes to determine if the King is in checkmate
	 * 
	 * 
	 * @param row_king row the king resides in
	 * @param col_king column the king resides in
	 * @param board 2D array of chess pieces to simulate a board
	 * @param o the King object
	 * @param row_checkingPiece row the piece that is attacking the king resides in
	 * @param col_checkingPiece column the piece that is attacking the king resides in
	 * @param checkingPiece the piece that is attacking the king
	 * @return if the King cannot move, and if the piece that is attacking the king cannot be
	 * captured/blocked
	 */
	
	public static boolean CheckMate(int row_king, int col_king, ChessPiece[][] board, ChessPiece o, int row_checkingPiece, int col_checkingPiece, ChessPiece checkingPiece)
	{
		if(Check(row_king, col_king, board,o) && CheckUp(row_king, col_king, board,o) && CheckDown(row_king, col_king, board,o) && CheckRight(row_king, col_king, board,o) && CheckLeft(row_king, col_king, board,o) && CheckUpperRight(row_king, col_king, board,o) && CheckUpperLeft(row_king, col_king, board,o) && CheckLowerRight(row_king, col_king, board,o) && CheckLowerLeft(row_king, col_king, board,o))
		{ // checks if the actual King cannot move
			
			//other conditions:
			// can the piece checking be taken
			
			
			if(!Check(row_checkingPiece, col_checkingPiece, board, checkingPiece)) //no piece can take the taking piece
			{
				return true;
			}
				
			
		}
		
		return false;
	}

}
