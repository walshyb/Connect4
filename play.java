import java.util.Scanner;

public class play 
{
    public static String[][] board = new String[7][7];
    public static Scanner kb = new Scanner(System.in);
    public static String p1 = "", p2 ="";

    public static void main(String[] args) 
    {
        makeBoard();
        addPiece(4,5, "r");
        showBoard();
    }
    
    //-----------------------------------------------------
    
    public static void intro()
    {
    	System.out.println("Welcome to Connect 4!");
    	
        System.out.println("Please enter the name of player one: ");
        p1 = kb.next();
        
        System.out.println("Please enter the name of player two: ");
        p2 = kb.next();
        
        makeBoard();
    }
    
    public static void makeBoard()
    {
    	for (int row = 0; row < board.length; row++)
        {   
            for(int col = 0; col < board[row].length; col++)
            {
                board[col][row] = "0";
            }
        }
    	
    }
    
    //------------------------------------------------------

    public static void showBoard()
    {       	
    	System.out.print("\n      0  1  2  3  4  5  6  ");
        System.out.print("\n    ---------------------");

        for (int row = 0; row < board.length; row++)
        {
            System.out.println("");
            System.out.print(" " + row + "  | ");
            
            for(int col = 0; col < board[row].length; col++)
            {
                //System.out.print(value);
            	
            	
                //board[col][row] = "0";
                
                
                if(board[col][row] == null)
                {
                  System.out.print("  ");
                }
                else
                {
                  System.out.print(board[col][row] + "  ");
                }
            }
        }
        
        System.out.println("");
    }
    
    //------------------------------------------------------
    
    public static void addPiece(int x, int y, String r)
    {
        board[x][y] = r;
    }   
    
    public static void play()
    {
    	intro();
    	while(true)
    	{
    		for (int row = 0; row < board.length; row++)
            {   
                for(int col = 0; col < board[row].length; col++)
                {
                    if(!(board[col][row] == "0"))
                    {
                    	System.out.println("It's a tie!");
                    	break;
                    }
                }
            }
    	}
    }
    
    public static int checkWin() 	//in progress
    {
    	int counter1 = 0;
    	 
        /* horizontally */
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == board[i][j + 1])
                    counter1++;
     
                if(counter1 == 4)
                    return 1;
            }
        }
     
        /* vertically */
        
        int counter2 = 0;
        for(int a = 0; a < board.length; a++) {
            for(int b = 0; b < board.length; b++) {
                if(board[b][a] == board[b + 1][a])
                    counter2++;
     
                if(counter2 == 4)
                    return 1;
            }
        }
     
        return 0;
   	 
    }
}