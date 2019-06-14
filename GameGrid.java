import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;  // Import the Scanner class

public class GameGrid {

    public static void run() {

        // Two ways to instantiate the same array
        //int[] aiNums = new int[]{2,5,3};

        int[] aiNums = new int[3];
        aiNums[0] = 2;
        aiNums[1] = 5;
        aiNums[2] = 3;

        //Sorts int and Strings alphabetically
        Arrays.sort(aiNums);

        System.out.println("Use the 's' and 'd' keys to move down and left \nAvoid the '1's'");

        //2D Array
        int[][] aiGrid = new int[10][10];
        int iWallChance = 10;
        int iTempNum;
        int iUserRow = 0;
        int iUserCol = 0;
        boolean bEndLoop;

        Scanner oUserInput = new Scanner(System.in);  // Create a Scanner object


        SecureRandom oRand = new SecureRandom();

        //Loop through rows
        for (int y = 0; y < aiGrid.length; y++) {

            //Loop through cols
            for (int x = 0; x < aiGrid[y].length; x++) {

                //Bound:10 means random numbers 0-9
                aiGrid[y][x] = oRand.nextInt(2);
            }
        }

        //Loop through rows
        for (int y = 0; y < aiGrid.length; y++) {

            //Loop through cols
            for (int x = 0; x < aiGrid[y].length; x++) {

                iTempNum = oRand.nextInt(100);

                // See if wall should be placed.
                if (iTempNum < iWallChance) {
                    aiGrid[y][x] = 1;
                }

                //otherwise, place a path.
                else {
                    aiGrid[y][x] = 0;
                }
            }
        }

        aiGrid[0][0] = 0;

        while( bEndLoop = true){

            char oInput = oUserInput.next().charAt(0);  // Read user input

            if (aiGrid[iUserCol][iUserRow] == 1){
                System.out.println("You Failed");
                break;
            }
            else if (iUserCol == 9 || iUserRow == 9){


                System.out.println("You Win!");
                break;
            }
            else if (oInput == 'd') {

                iUserCol++;
            }
            else if (oInput == 's'){

                iUserRow++;
            }

        }

        for (int y = 0; y < aiGrid.length; y++) {

            //Loop through cols
            for (int x = 0; x < aiGrid[y].length; x++) {

                //One form of printing out array
                //System.out.println("2D Array[" + y + "]" + "[" + x + "]" + "=" + aiGrid[y][x]);

                //Another form for printing array
                if( y == iUserRow && x == iUserCol){
                    System.out.print("X ");
                }
                else{
                    System.out.print(aiGrid[y][x] + " ");
                }

            }

            System.out.println("");
        }
    }
}
