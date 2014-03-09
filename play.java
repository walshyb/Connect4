import java.util.Scanner;

public class play
{
    private static String[][] board = new String[7][7];
    private static Scanner kb = new Scanner(System.in);
    private static String p1 = "", p2 ="";
    private static int play = 1;
    private static String value = "";
    
    public static void main(String[] args)
    {
    	intro();
        showBoard();
        turn();
        turn();
        turn();
        turn();
        turn();
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
    
    public static void addPiece()
    {
    	System.out.println("Please enter the column number: ");
    	int x = kb.nextInt();
    	
    	/*System.out.println("Plese enter the column number: ");
         int y = kb.nextInt();*/
		
    	int y = 0;
    	
		if(!(play % 2 == 0))
		{
			value = "R";
		}
		else
		{
			value = "Y";
		}
		
    	
    	for(int row = 0; row < board.length; row++)
    	{
    		try
    		{
        		if(board[x][row] == "0")
        		{
        			board[x][row-1] = "0";
        			board[x][row] = value;
        		}
    			
        		
    		}
    		catch(ArrayIndexOutOfBoundsException a)
    		{
    			
    		}
    		
    		play++;
    		
    	}
    	
    	/*if(play == 2)
         {
         for(int row = 0; row < board.length; row++)
         {
         board[x][row] = "0";
         
         if(!(board[x][row] == "0"))
         {
         if(!(play % 2 == 0))
         {
         value = "R";
         }
         else
         {
         value = "Y";
         }
         }
         }
         }*/
		
		
		
		/*while(true)
         {
         board[x][y+1] = "0";
         
         if(!(board[x][y] == "0"))
         {
         if(!(play % 2 == 0))
         {
         value = "R";
         break;
         }
         else
         {
         value = "Y";
         break;
         }
         
         
         }
         }*/
		
        //board[x][y] = value;
    	
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
    
    public static void turn()
    {
    	if(!(play % 2 == 0))
    	{
    		System.out.println("\n" + p1 + "'s turn");
    		value = "R";
    		addPiece();
    	}
    	else
    	{
    		System.out.println("\n" + p2 + "'s turn");
    		value = "Y";
    		addPiece();
    	}
    	
    	showBoard();
    }
}