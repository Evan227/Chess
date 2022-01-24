package board;

/**
 * This class implements a 2D array of chess pieces and also initializes all of those chess pieces
 * to put into the array
 * 
 * @author Evan Liu
 * @version 2.0
 *
 */

public class Chessboard {
	
	/**
	 * the 2D array that will act as our chess board
	 */
	public final static  ChessPiece[][] ChessBoard = new ChessPiece[9][9];

	
	
	static Rook blackRook1 = new Rook(false, "bR", false);
	static Rook blackRook2 = new Rook(false, "bR", false);
	static Rook whiteRook1 = new Rook(true, "wR", false);
	static Rook whiteRook2 = new Rook(true, "wR", false);
	static Knight blackKnight1 = new Knight(false, "bN");
	static Knight blackKnight2 = new Knight(false, "bN");
	static Knight whiteKnight1 = new Knight(true, "wN");
	static Knight whiteKnight2 = new Knight(true, "wN");
	static Bishop blackBishop1 = new Bishop(false, "bB");
	static Bishop blackBishop2 = new Bishop(false, "bB");
	static Bishop whiteBishop1 = new Bishop(true, "wB");
	static Bishop whiteBishop2 = new Bishop(true, "wB");
	static Queen blackQueen = new Queen(false, "bQ");
	static King blackKing = new King(false, "bK", false);
	static Queen whiteQueen = new Queen(true, "wQ");
	static King whiteKing = new King(true, "wK", false);
	
	static Pawn blackPawn1 = new Pawn(false, "bp", true);
	static Pawn blackPawn2 = new Pawn(false, "bp", true);
	static Pawn blackPawn3 = new Pawn(false, "bp", true);
	static Pawn blackPawn4 = new Pawn(false, "bp", true);
	static Pawn blackPawn5 = new Pawn(false, "bp", true);
	static Pawn blackPawn6 = new Pawn(false, "bp", true);
	static Pawn blackPawn7 = new Pawn(false, "bp", true);
	static Pawn blackPawn8 = new Pawn(false, "bp", true);
	
	static Pawn whitePawn1 = new Pawn(true, "wp", true);
	static Pawn whitePawn2 = new Pawn(true, "wp", true);
	static Pawn whitePawn3 = new Pawn(true, "wp", true);
	static Pawn whitePawn4 = new Pawn(true, "wp", true);
	static Pawn whitePawn5 = new Pawn(true, "wp", true);
	static Pawn whitePawn6 = new Pawn(true, "wp", true);
	static Pawn whitePawn7 = new Pawn(true, "wp", true);
	static Pawn whitePawn8 = new Pawn(true, "wp", true);
	
	static ChessPiece one = new ChessPiece(true, "1");
	static ChessPiece two = new ChessPiece(true, "2");
	static ChessPiece three = new ChessPiece(true, "3");
	static ChessPiece four = new ChessPiece(true, "4");
	static ChessPiece five = new ChessPiece(true, "5");
	static ChessPiece six = new ChessPiece(true, "6");
	static ChessPiece seven = new ChessPiece(true, "7");
	static ChessPiece eight = new ChessPiece(true, "8");
	
	static ChessPiece a = new ChessPiece(true, "a");
	static ChessPiece b = new ChessPiece(true, "b");
	static ChessPiece c = new ChessPiece(true, "c");
	static ChessPiece d = new ChessPiece(true, "d");
	static ChessPiece e = new ChessPiece(true, "e");
	static ChessPiece f = new ChessPiece(true, "f");
	static ChessPiece g = new ChessPiece(true, "g");
	static ChessPiece h = new ChessPiece(true, "h");
	
	/**
	 * this class sets all the initialized chess pieces into their respective starting places
	 */
	
	public void set()
	{
		ChessBoard[0][0] = blackRook1;
		ChessBoard[0][1] = blackKnight1;
		ChessBoard[0][2] = blackBishop1;
		ChessBoard[0][3] = blackQueen;
		ChessBoard[0][4] = blackKing;
		ChessBoard[0][5] = blackBishop2;
		ChessBoard[0][6] = blackKnight2;
		ChessBoard[0][7] = blackRook2;
		ChessBoard[1][0] = blackPawn1;
		ChessBoard[1][1] = blackPawn2;
		ChessBoard[1][2] = blackPawn3; //1,2 original
		ChessBoard[1][3] = blackPawn4;
		ChessBoard[1][4] = blackPawn5;
		ChessBoard[1][5] = blackPawn6;
		ChessBoard[1][6] = blackPawn7;
		ChessBoard[1][7] = blackPawn8;
		
		ChessBoard[7][0] = whiteRook1;
		ChessBoard[7][1] = whiteKnight1;
		ChessBoard[7][2] = whiteBishop1;
		ChessBoard[7][3] = whiteQueen;
		ChessBoard[7][4] = whiteKing;
		ChessBoard[7][5] = whiteBishop2;
		ChessBoard[7][6] = whiteKnight2;
		ChessBoard[7][7] = whiteRook2;
		ChessBoard[6][0] = whitePawn1;
		ChessBoard[6][1] = whitePawn2;
		ChessBoard[6][2] = whitePawn3;
		ChessBoard[6][3] = whitePawn4;
		ChessBoard[6][4] = whitePawn5;
		ChessBoard[6][5] = whitePawn6;
		ChessBoard[6][6] = whitePawn7;
		ChessBoard[6][7] = whitePawn8;
		
		ChessBoard[0][8] = eight;
		ChessBoard[1][8] = seven;
		ChessBoard[2][8] = six;
		ChessBoard[3][8] = five;
		ChessBoard[4][8] = four;
		ChessBoard[5][8] = three;
		ChessBoard[6][8] = two;
		ChessBoard[7][8] = one;
		
		ChessBoard[8][0] = a;
		ChessBoard[8][1] = b;
		ChessBoard[8][2] = c;
		ChessBoard[8][3] = d;
		ChessBoard[8][4] = e;
		ChessBoard[8][5] = f;
		ChessBoard[8][6] = g;
		ChessBoard[8][7] = h;
		
	}
	
	/**
	 * this class implements the ascii art of the chess board
	 */
	
	public void AsciiDraw()
	{
		for(int x = 0; x<9;x++)
		{
			for(int y = 0; y<9;y++)
			{
				if(ChessBoard[x][y] == null)
				{
					if(x%2 == 0 && y%2 == 1)
					{
						System.out.print("## ");
					}
					else if(x%2 == 1 && y%2 == 0)
					{
						System.out.print("## ");
					}
					else
					{
						System.out.print("   ");
					}	
				}
				else
				{
					if(x != 8)
					{
						System.out.print(ChessBoard[x][y].getString());
						System.out.print(" ");
					}
					else
					{
						System.out.print(" " + ChessBoard[x][y].getString());
						System.out.print(" ");
					}
					
				}
			}
			
			System.out.println();
		}
	}
	

	
	
	
	
}
