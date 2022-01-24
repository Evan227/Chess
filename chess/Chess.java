package chess;

import board.*;

import java.util.Scanner;

/**
 * This is the main tester class
 * 
 * @author Evan Liu
 * @version 5.0
 */

public class Chess {
	
			
/**
 * main tester class to play chess
 */
public static void main(String[] args) {
		
		Chessboard ChessBoard = new Chessboard();
		
		ChessBoard.set();
		ChessBoard.AsciiDraw();
		
		  int blackKing_row = 0;
		  int blackKing_col = 4;
		  int whiteKing_row = 7;
		  int whiteKing_col = 4;
		
		boolean white = true;
		boolean draw = false;
		
		boolean whiteCheckMate = false;
		boolean blackCheckMate = false;
		
		
		while(!whiteCheckMate && !blackCheckMate)
		{
			Scanner sc= new Scanner(System.in);
			
			
			if(white)
			{
				System.out.print("White move: ");  
			}
			else
			{
				System.out.print("Black move: ");  
			}
			
			
			
			String move = sc.nextLine();
			
			if(move.equals("resign"))
			{
				if(white)
				{
					System.out.println("Black wins");
				}
				else
				{
					System.out.println("White wins");
				}
				
				return;
			}
			
			if(draw == true)
			{
				if(move.equals("draw"))
				{
					return;
				}
				else
				{
					System.out.println("Illegal move, try again");
					continue;
				}
			}
			
			int row1 = 8 - (move.charAt(1) - 48);
			int col1 = move.charAt(0) - 97;
			
			int row2 = 8 - (move.charAt(4) - 48);
			int col2 = move.charAt(3) - 97;
			
		
			
			if(move.length() == 11)
			{
				if(move.substring(6, 11).equals("draw?"))
				{
					draw = true;
				}
			}
			
			/*System.out.println(col1);
			System.out.println(row1);
			System.out.println(col2);
			System.out.println(row2);*/
			
			if(col1 < 0 || col1 > 8 || row1 < 0 || row1 > 8 || col2 < 0 || col2 > 8 || row2 < 0 || row2 > 8)
			{
				System.out.println("Illegal move, try again");
				continue;
			}
			else
			{
				ChessPiece holder = Chessboard.ChessBoard[row1][col1];
				boolean goodMove = false;
				
				if(holder == null)
				{
					System.out.println("Illegal move, try again");
					continue;
				}
				if(white == holder.white && holder instanceof Pawn)
				{
					if(white)
					{
						goodMove = Pawn.isValidMoveWhite(col1, row1, col2, row2, ChessBoard.ChessBoard, (Pawn)ChessBoard.ChessBoard[row1][col1]);
						
						
						
						if(row2 == 0 && goodMove && move.length() > 5 )
						{
							if(move.charAt(6) == 'R')
							{
								holder = new Rook(true, "wR", true);
							}
							else if(move.charAt(6) == 'N')
							{
								holder = new Knight(true, "wK");
							}
							else if(move.charAt(6) == 'B')
							{
								holder = new Bishop(true, "wB");
							}
							else if(move.charAt(6) == 'Q')
							{
								holder = new Queen(true, "wQ");
							}
							else
							{
								goodMove = false;
							}
							
						}
						else if(row2 == 0 && goodMove)
						{
							holder = new Queen(true, "wQ");
						}
					}
					else
					{
						goodMove = Pawn.isValidMoveBlack(col1, row1, col2, row2, ChessBoard.ChessBoard,(Pawn)ChessBoard.ChessBoard[row1][col1]);
						
						if(row2 == 7 && goodMove && move.length() > 5 )
						{
							if(move.charAt(6) == 'R')
							{
								holder = new Rook(true, "wR", true);
							}
							else if(move.charAt(6) == 'N')
							{
								holder = new Knight(true, "wK");
							}
							else if(move.charAt(6) == 'B')
							{
								holder = new Bishop(true, "wB");
							}
							else if(move.charAt(6) == 'Q')
							{
								holder = new Queen(true, "wQ");
							}
							else
							{
								goodMove = false;
							}
							
						}
						else if(row2 == 7 && goodMove)
						{
							holder = new Queen(true, "wQ");
						}
					}
				}
				else if(white == holder.white && holder instanceof Bishop)
				{
					goodMove = Bishop.isValidMove(col1, row1, col2, row2, ChessBoard.ChessBoard, (Bishop)ChessBoard.ChessBoard[row1][col1]);
				}
				else if(white == holder.white && holder instanceof Rook)
				{
					goodMove = Rook.isValidMove(col1, row1, col2, row2, ChessBoard.ChessBoard, (Rook)ChessBoard.ChessBoard[row1][col1]);
				}
				else if(white == holder.white && holder instanceof Queen)
				{
					goodMove= Queen.isValidMove(col1, row1, col2, row2, ChessBoard.ChessBoard, holder);
				}
				else if(white == holder.white && holder instanceof King)
				{
					
					if(white)
					{
					
						
						goodMove = King.isValidMove(col1, row1, col2, row2, ChessBoard.ChessBoard, (King)holder) && !King.Check(row2, col2, ChessBoard.ChessBoard, holder);
						
						if(goodMove)
						{
							whiteKing_row =row2;
							whiteKing_col =col2;
						}
					}
					else
					{
					
						
						goodMove = King.isValidMove(col1, row1, col2, row2, ChessBoard.ChessBoard, (King) holder) && !King.Check(row2, col2, ChessBoard.ChessBoard, holder);
					
						if(goodMove)
						{
							blackKing_row =row2;
							blackKing_col =col2;
						}
					}
					
					
					
					
				}
				else if(white == holder.white && holder instanceof Knight)
				{
					goodMove = Knight.isValidMove(col1, row1, col2, row2, ChessBoard.ChessBoard, holder);
				}
				
			
				
				
				if(goodMove)
				{
				
					Chessboard.ChessBoard[row1][col1] = null;
				
					Chessboard.ChessBoard[row2][col2] = holder;
				}
				else
				{
					System.out.println("Illegal move, try again");
					continue;
				}
			}
			
			ChessBoard.AsciiDraw();
			
			
			if(!white && !Pawn.whitePawnEnpassant.isEmpty())
			{
				Pawn.whitePawnEnpassant.remove(0);
			}
			else if(white && !Pawn.blackPawnEnpassant.isEmpty())
			{
				Pawn.blackPawnEnpassant.remove(0);
			}
			
			white = !white;
			
			
			
			if(white && King.Check(whiteKing_row, whiteKing_col, ChessBoard.ChessBoard, (King)ChessBoard.ChessBoard[whiteKing_row][whiteKing_col]))
			{
				
					
				whiteCheckMate = King.CheckMate(whiteKing_row, whiteKing_col, ChessBoard.ChessBoard, (King)ChessBoard.ChessBoard[whiteKing_row][whiteKing_col], row2, col2, ChessBoard.ChessBoard[row2][col2]);
				
				if(whiteCheckMate)
				{
					System.out.println("Checkmate");
					break;
				}
				
				System.out.println("Check");
			}
			else if(!white && King.Check(blackKing_row, blackKing_col, ChessBoard.ChessBoard, (King)ChessBoard.ChessBoard[blackKing_row][blackKing_col]))
			{
				
				
				blackCheckMate = King.CheckMate(blackKing_row, blackKing_col, ChessBoard.ChessBoard, (King)ChessBoard.ChessBoard[blackKing_row][blackKing_col], row2, col2, ChessBoard.ChessBoard[row2][col2]);
				
				if(blackCheckMate)
				{
					System.out.println("Checkmate");
					break;
				}
				
				System.out.println("Check");
			}
			
			
			
		}
		
		
		if(white)
		{
			System.out.println("Black wins");
		}
		else
		{
			System.out.println("White wins");
		}

	}









}