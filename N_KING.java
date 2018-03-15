import java.util.Scanner;

public class N_KING {
    public static void main(String[] args) {
        
    	
    	int row = 0;
    	 int column = 0;
    	 int solutions = 0;
    	Scanner key = new Scanner(System.in);
        System.out.print("Enter number of Rows and Colum you want: ");
        int R = key.nextInt();
        
        int[] playboard = new int[R];
        for (int a = 0; a < playboard.length; a++) {
        	playboard[a] = -1;
        }

       
        
        playboard[row] = 0;
        row++;
       
        
        while (row >= 0) {
            if (isright(row, column, playboard)) {
            	playboard[row] = column;
                row++;
                column = 0;

                
                if (row >= playboard.length) {
                	solutions++;
                    System.out.println("Solution " + solutions);
                    
                	printStyle(playboard);
                    row--;
                    column = playboard[row] + 1;
                }
            }
            
            else {
                
                column++;
                if (column >= playboard.length) {
                    playboard[row] = -1;
                    row--;
                    if (row >= 0)
                        column = playboard[row] + 1;
                }
                
            }
            
        }
        System.out.println("Number of solutions  " + solutions); 
    }

    public static boolean isright(int row, int column, int[] board) {
        if (column >= board.length)
            return false;

        for (int i = 0; i < row; i++) {
           
            if (board[i] == column)
                return false;

            
            if (Math.abs(row - i) == Math.abs(column - board[i])) 
                return false;
        }

        return true;
    }

    public static void printStyle(int[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i] == j)
                    System.out.print("|K");
                else
                    System.out.print("! ");
            }
            System.out.println("!");
        }
    }
}