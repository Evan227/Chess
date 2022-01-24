package board;

/**
 * this represents a chess piece
 * 
 * @author Evan Liu
 * @version 3.0
 */

public class ChessPiece {
	
	/**
	 * determines if the piece if white or black
	 */
	public boolean white;
	String name;
	
	/**
	 * creates a chess piece to put on the board
	 * 
	 * @param white whether or not it's a white or black piece
	 * @param name output string that will be shown in the ascii art
	 */
	
	public ChessPiece(boolean white, String name)
	{
		this.white = white;
		this.name = name;
	}
	
	/**
	 * returns name of the chess piece  
	 * @return the name of the chess piece
	 */
	public String getString()
	{
		return name;
	}

	/**
	 * determines if the piece in the specified spot is the same color as this piece
	 * 
	 * @param board the 2D array of Chess pieces
	 * @param row the row of the piece
	 * @param col the column of the piece
	 * @return whether or not the piece in the spot is the same color as this piece
	 */
	public boolean isOppositeColor(ChessPiece[][] board, int row, int col)
	{
		
		return board[row][col].white != white;
	}
	
	/**
	 * 
	 * determines if the specified spot is empty
	 * 
	 * @param board the 2D array of Chess pieces
	 * @param row the row of the piece
	 * @param col the column of the piece
	 * @return whether or not the specified spot is empty
	 */
	
	public static boolean isEmptySpace(ChessPiece[][] board, int row, int col)
	{
		return board[row][col] == null;
	}
	
	/**
	 * 
	 * determines if the row and col is within the bounds of the array 
	 * 
	 * @param board the 2D array of Chess pieces
	 * @param row the row of the piece
	 * @param col the column of the piece
	 * @return whether or not the row and col are within the bounds of the array
	 */
	
	public static boolean inBounds(ChessPiece[][] board, int row, int col)
	{
		return (row >= 0) && (row < board[0].length-1) && col >= 0 && col < board.length-1;
	}
	
	

}
