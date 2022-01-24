package board;

import java.util.ArrayList;

/**
 * This class represents a Pawn
 * 
 * @author Evan Liu
 * @version 1
 */

public class Pawn extends ChessPiece{
	
	/**
	 * list to show which white pawns have the ability to be taken through enpassant
	 */
	public static ArrayList<Pawn> whitePawnEnpassant = new ArrayList<Pawn>();
	
	/**
	 * list to show which black pawns have the ability to be taken through enpassant
	 */
	public static ArrayList<Pawn> blackPawnEnpassant = new ArrayList<Pawn>();
	
	/**
	 * shows whether or not this piece is on its first move or not
	 */
	public boolean firstMove;
	
	/**
	 * creates a Pawn, a chess piece that can move one space forward, however capture pieces diagonally
	 * 
	 * @param white whether it's a white piece or a black piece
	 * @param name output string that will be shown in the ascii art
	 * @param firstMove shows whether or not this is its first move or not
	 */
	public Pawn(boolean white, String name, boolean firstMove)
	{
		super(white, name);
		this.firstMove = firstMove;
	}
	
	/**
	 * This is a boolean method to check if the Pawn can be moved from its initial spot to 
	 * the end spot that we're trying to get to. This is specific to white pawns since white pawns
	 * move in a different direction than black pawns
	 * 
	 * 
	 * 
	 * @param initial_col initial column that the Pawn resides in
	 * @param initial_row initial row that the Pawn resides in
	 * @param end_col column that we're trying to move the Bishop to
	 * @param end_row row that we're trying to move the Bishop to
	 * @param board the 2D array of Chess pieces that contains the Knight
	 * @param o the actual Pawn object in the 2D array
	 * @return whether or not the move from [initial_row][initial_col] to [end_row][end_col] can be executed
	 */
	
	public static boolean isValidMoveWhite(int initial_col, int initial_row, int end_col, int end_row, ChessPiece[][] board, Pawn o)
	{
		
		//have to implement different methods for white and black because the pawns head in different directions
		
		if(o.firstMove == true) //allows pawns to move 2 or 1 space the first move and sets the first move boolean to false
		{
			if(initial_col == end_col && initial_row-2 == end_row && board[end_row][end_col] == null)
			{
				o.firstMove = false;
				whitePawnEnpassant.add(o);
				return true;
			}
			else if(initial_col == end_col && initial_row-1 == end_row && board[end_row][end_row] == null)
			{
				o.firstMove = false;
				whitePawnEnpassant.add(o);
				return true;
			}
			else if(inBounds(board, initial_row-1, initial_col+1) && board[initial_row-1][initial_col+1] != null && board[initial_row-1][initial_col+1].white != o.white && end_row + 1 == initial_row && end_col-1 == initial_col)
			{ //if there's an object to the right diagonal the pawn can take it
				return true;
			}
			else if(inBounds(board, initial_row-1, initial_col-1) && board[initial_row-1][initial_col-1] != null && board[initial_row-1][initial_col-1].white != o.white && end_row +1 == initial_row && end_col+1==initial_col)
			{ //if there's an object to the left diagonal the pawn can take it
				return true;
			}
		}
		else
		{
			if(initial_col == end_col && initial_row-1 == end_row && board[end_row][end_col] == null)
			{ //standard 1 space move
				return true;
			}
			else if(inBounds(board, initial_row-1, initial_col+1) && board[initial_row-1][initial_col+1] != null && board[initial_row-1][initial_col+1].white != o.white && end_row + 1 == initial_row && end_col-1 == initial_col)
			{ //if there's an object to the right diagonal the pawn can take it
				return true;
			}
			else if(inBounds(board, initial_row-1, initial_col-1) && board[initial_row-1][initial_col-1] != null && board[initial_row-1][initial_col-1].white != o.white && end_row +1 == initial_row && end_col+1==initial_col)
			{ //if there's an object to the left diagonal the pawn can take it
				return true;
			}
			else if(inBounds(board, initial_row, initial_col+1) && board[initial_row][initial_col+1] != null && board[initial_row][initial_col+1] instanceof Pawn && board[initial_row][initial_col+1].white != o.white && end_row + 1 == initial_row && end_col-1 == initial_col)
			{ //if there's an object to the right, en passant
				if(inEnpassant((Pawn) board[initial_row][initial_col+1], blackPawnEnpassant))
				{
					board[initial_row][initial_col+1] = null;
					return true;
				}
			}
			else if(inBounds(board, initial_row, initial_col-1) && board[initial_row][initial_col-1] != null && board[initial_row][initial_col-1] instanceof Pawn && board[initial_row][initial_col-1].white != o.white && end_row +1 == initial_row && end_col+1==initial_col)
			{ //if there's an object to the left, en passant
				if(inEnpassant((Pawn) board[initial_row][initial_col-1], blackPawnEnpassant))
				{
					board[initial_row][initial_col-1] = null;
					return true;
				}
			}
		}
		
		return false;
	}

	
	/**
	 * This is a boolean method to check if the Pawn can be moved from its initial spot to 
	 * the end spot that we're trying to get to. This is specific to black pawns since black pawns
	 * move in a different direction than white pawns
	 * 
	 * 
	 * 
	 * @param initial_col initial column that the Pawn resides in
	 * @param initial_row initial row that the Pawn resides in
	 * @param end_col column that we're trying to move the Bishop to
	 * @param end_row row that we're trying to move the Bishop to
	 * @param board the 2D array of Chess pieces that contains the Knight
	 * @param o the actual Pawn object in the 2D array
	 * @return whether or not the move from [initial_row][initial_col] to [end_row][end_col] can be executed
	 */
	
	public static boolean isValidMoveBlack(int initial_col, int initial_row, int end_col, int end_row, ChessPiece[][] board, Pawn o)
	{
		if(o.firstMove == true)
		{
			if(initial_col == end_col && initial_row+2 == end_row && board[end_row][end_col] == null)
			{
				o.firstMove = false;
				blackPawnEnpassant.add(o);
				return true;
			}
			else if(initial_col == end_col && initial_row+1 == end_row && board[end_row][end_col] == null)
			{
				o.firstMove = false;
				blackPawnEnpassant.add(o);
				return true;
			}
			else if(inBounds(board, initial_row+1, initial_col+1) && board[initial_row+1][initial_col+1] != null && o.isOppositeColor(board, initial_row+1, initial_col+1) && end_row -1 == initial_row && end_col-1==initial_col)
			{ //if there's an object to the right diagonal the pawn can take it
				return true;
			}
			else if(inBounds(board, initial_row+1, initial_col-1) && board[initial_row+1][initial_col-1] != null && board[initial_row+1][initial_col-1].white != o.white &&  end_row -1 == initial_row && end_col+1==initial_col)
			{ //if there's an object to the left diagonal the pawn can take it
				return true;
			}
		}
		else
		{ 
			if(initial_col == end_col && initial_row+1 == end_row)
			{
				return true;
			}
			else if(inBounds(board, initial_row+1, initial_col+1) && board[initial_row+1][initial_col+1] != null && o.isOppositeColor(board, initial_row+1, initial_col+1) && end_row -1 == initial_row && end_col-1==initial_col)
			{ //if there's an object to the right diagonal the pawn can take it
				return true;
			}
			else if(inBounds(board, initial_row+1, initial_col-1) && board[initial_row+1][initial_col-1] != null && board[initial_row+1][initial_col-1].white != o.white &&  end_row -1 == initial_row && end_col+1==initial_col)
			{ //if there's an object to the left diagonal the pawn can take it
				return true;
			}
			else if(inBounds(board, initial_row, initial_col+1) && board[initial_row][initial_col+1] != null && board[initial_row][initial_col+1] instanceof Pawn && board[initial_row][initial_col+1].white != o.white && end_row -1 == initial_row && end_col-1==initial_col)
			{ //if there's an object to the right, en passant
				if(inEnpassant((Pawn) board[initial_row][initial_col+1], whitePawnEnpassant))
				{
					board[initial_row][initial_col+1] = null;
					return true;
				}
			}
			else if(inBounds(board, initial_row, initial_col-1) && board[initial_row][initial_col-1] != null && board[initial_row][initial_col-1] instanceof Pawn && board[initial_row][initial_col-1].white != o.white &&  end_row -1 == initial_row && end_col+1==initial_col)
			{ //if there's an object to the left, en passant
				if(inEnpassant((Pawn) board[initial_row][initial_col-1], whitePawnEnpassant))
				{
					board[initial_row][initial_col-1] = null;
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * method to see if there's an object in the list
	 * 
	 * @param o object we're checking if it's in the arrayList
	 * @param list list of pawns that just made their first double spaced move
	 * @return if the o object is in the list
	 */
	public static boolean inEnpassant(Pawn o, ArrayList<Pawn> list)
	{
		return list.contains(o);
	}
	
	/**
	 * This method checks there's any pawns attacking a specific space
	 * 
	 * @param row row that we're checking is being attacked
	 * @param col column that we're checking is being attacked
	 * @param board 2D array that simulates a chess board
	 * @param o the King object or the object that is being attacked
	 * @return whether or not there's a pawn attacking this object o
	 */
	
	public static boolean Check(int row, int col, ChessPiece[][] board, ChessPiece o)
	{
		if(inBounds(board, row-1, col-1) && !isEmptySpace(board, row-1, col-1) && o.white && o.isOppositeColor(board, row-1, col-1) &&  board[row-1][col-1] instanceof Pawn)
		{
			return true;
		}//black pawn attacking white king from upper right
		else if(inBounds(board, row-1, col+1) && !isEmptySpace(board, row-1, col+1) && o.white && o.isOppositeColor(board, row-1, col+1) &&  board[row-1][col+1] instanceof Pawn)
		{
			return true;
		}//white pawn attacking black king from lower left
		else if(inBounds(board, row+1, col-1) && !isEmptySpace(board, row+1, col-1) && !o.white && o.isOppositeColor(board, row+1, col-1) &&  board[row+1][col-1] instanceof Pawn)
		{
			return true;
		}//white pawn attacking black king from lower right
		else if(inBounds(board, row+1, col+1) && !isEmptySpace(board, row+1, col+1) && !o.white && o.isOppositeColor(board, row+1, col+1) &&  board[row+1][col+1] instanceof Pawn)
		{
			return true;
		}
		
		return false;
	}

	
}
