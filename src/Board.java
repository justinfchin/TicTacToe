/**
 * Board Class for TicTacToe
 * @author Justin Chin
 * @version 1.0
 * @since Jan. 3, 2017
 */
public class Board {
    private int size;                           //# of rows and columns
    private Piece boardArray[][];              //array of Players

    public int currentRow, currentCol;     //current selected Row and Column

    public enum Piece{
        EMPTY, X,O;
    }


    public Board(int size){
        this.size = size;                       //initialize size
        boardArray = new Piece[size][size];    //initialize data structure
    }

    /**
     * Checks if Board is Full There is a Draw
     * @return True if Board is Full, else False.
     */
    public boolean isDraw(){
        //Loop through all the elements
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(boardArray[i][j] == Piece.EMPTY) return false;
            }
        }
        return true;
    }

    /**
     * Checks if There is a winner
     * @param thePiece Player to be Checked if Winner
     * @return True if There is a Winner, else False.
     */
    public boolean isWin(Piece thePiece){
        return (rowWin(thePiece) || columnWin(thePiece) || diagonalWin(thePiece) || rDiagonalWin(thePiece));
    }

    /**
     * Set Board Cell with Piece
     * @param piece Piece
     * @param row Row
     * @param col Column
     */
    public void setBoardCell(Piece piece, int row, int col){
        boardArray[row][col] = piece;
    }

    /**
     * Checks if there is a Row Win.
     * @param thePiece Player to be checked if Winner
     * @return True if there is a Row Win, else False.
     */
    private boolean rowWin(Piece thePiece){
        for(int i = 0; i < size; i++){
            if(boardArray[currentRow][i] != thePiece) return false;
        }

        return true;
    }

    /**
     * Checks if there is a Column Win
     * @param thePiece Player to be checked if Winner
     * @return True if there is a Column Win, else False.
     */
    private boolean columnWin(Piece thePiece){
        for(int i = 0; i < size; i++){
            if(boardArray[i][currentCol] != thePiece) return false;
        }

        return true;
    }

    /**
     * Checks if there is a Diagonal Win
     * @param thePiece Player to be checked if Winner
     * @return True if there is a Diagonal Win, else False.
     */
    private boolean diagonalWin(Piece thePiece){
        for(int i = 0; i < size; i++){
            if(boardArray[i][i] != thePiece) return false;
        }

        return true;
    }

    /**
     * Checks if there is a reverse Diagonal Win
     * @param thePiece Player to be checked if Winner
     * @return True if there is a Diagonal Win, else False.
     */
    private boolean rDiagonalWin(Piece thePiece){
        for(int i = 0; i < size; i++){
            if(boardArray[i][size-1-i] != thePiece) return false;
        }

        return true;
    }

    /**
     * Get the size of the board
     * @return size of the board
     */
    public int getSize(){
        return size;
    }

    /**
     * Resets the Board
     */
    public void reset(){
        boardArray = new Piece[size][size]; //creates a new array
    }

    /**
     * Display the Board
     */
    public void printBoard() {
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                System.out.print(boardArray[row][col]);
                if (col < size - 1) System.out.print("|");
            }
            System.out.println();
            if (row < size - 1) {
                System.out.println("-----------------");
            }
        }
    }
}
