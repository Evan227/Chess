package board;

/**
 * This class represents a Queen
 * 
 * @author evanliu
 *
 */

public class Queen extends ChessPiece{
	
	/**
	 * creates a Queen, a chess piece that can move like a rook and a bishop
	 * 
	 * @param white whether it's a white piece or a black piece
	 * @param name output string that will be shown in the ascii art
	 */
	
	public Queen(boolean white, String name)
	{
		super(white, name);
	}
	
	/**
	 * This is a boolean method to check if the Queen can be moved from its initial spot to 
	 * the end spot that we're trying to get to. 
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
	
	public static boolean isValidMove(int initial_col, int initial_row, int end_col, int end_row, ChessPiece[][] board, ChessPiece o)
	{
		Rook rook;
		
		if(o.white)
		{
			rook = new Rook(true, "wR", false);
		}
		else
		{
			rook = new Rook(false, "bR", false);
		}

		return Rook.isValidMove(initial_col, initial_row, end_col, end_row, board, rook) || Bishop.isValidMove(initial_col, initial_row, end_col, end_row, board, o);
	}
	
	

}
