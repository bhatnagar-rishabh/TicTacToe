import java.util.ArrayList;

public class Board() {
    private int boardSize;
    private ArrayList[] boardList; 
    
    public Board(int n=3){
        //User Inmput for Board Size NxN
        this.boardSize = n;

        //Initialize Board
        
    }
    
    // For creating Board based on User input NxN
    void resetBoard(){
        //Display Board with Positions
        for(int i=1,j=1; i<=this.boardSize; i++){
            for(; j<i+this.boardSize; j++){
                System.out.print("| "+j+" ");
            }
            System.out.print(" |");
        } 
    }
    
    // Printing the Board 
    void printBoard(){
        for(int i=0,j=0; i<=this.boardSize; i++){
            for(; j<i+this.boardSize; j++){
                System.out.print("| "+this.boardList[j]+" ");
            }
            System.out.print(" |");
            System.out.println("");
        } 
    }

    // Updating the Board
    void updateBoard(int pos, int value){
        this.boardList[pos+1] = value;
        checkWinning();
    }

    // Check winning condition on Board
    boolean checkWinning(){
        return ;
    }
}