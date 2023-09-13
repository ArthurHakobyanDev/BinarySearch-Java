//Arthur Hakobyan
//Project 3 Divide and Conquer
//CS482
//5 November 2022



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.*;
import java.util.*;


public class Project3 {
    public static void main(String[] args) throws FileNotFoundException
    {
        String str;
        File file = new File("src/input.txt");
        Scanner scan = new Scanner(file);
        str = scan.nextLine();
        int element = Integer.valueOf(scan.nextLine());
        element = 57;
        int nrows = Character.getNumericValue(str.charAt(0));
        int ncol = Character.getNumericValue(str.charAt(2));


        int[][] arr = new int[nrows][ncol];
        String[] arrHelp = new String[100];



//Iterates through input.txt and passes values into 2d array

        for (int i = 0; i < nrows; i++) {
            str = scan.nextLine();
            arrHelp = str.split(" ");
                arrHelp = str.split(" ");
                for(int n = 0; n < ncol; n++)
                {
                    arr[i][n] = Integer.valueOf(arrHelp[n]);
                }
        }


        find_target(arr, 0, nrows-1, 0, ncol-1, element);
        //System.out.println(Arrays.deepToString(arr));

    }


    public static void find_target(int[][] arr, int row, int row2, int col, int col2, int target) {
        int target_row = row + (row2-row)/2;  //Base case middle of array
        int target_col = col + (col2-col)/2;
        if(arr[(target_row)][(target_col)] == target)
        {
            System.out.println(target_row + 1 + " " + (target_col+1));
        }
        else if(row == row2 && col == col2)
        {
            //Checks for 1x1 array
        }
        else {

            //Conditionals are used to check boundaries to prevent infinite recursive calls

            if (arr[(target_row)][(target_col)] > target) {
                if (target_col - 1 >= col && target_row - 1 >= row) {
                    find_target(arr, row, target_row - 1, col, target_col - 1, target); //checks upper left array
                }
                if (target_row - 1 >= row) {
                    find_target(arr, row, target_row - 1, target_col, col2, target);   //checks upper right array
                }
                if (target_col - 1 >= col) {
                    find_target(arr, target_row, row2, col, target_col - 1, target); //checks bottom left array
                }
            } else if (arr[(target_row)][(target_col)] < target) {
                if (target_row + 1 <= row2 && target_col + 1 <= col2) {
                    find_target(arr, target_row + 1, row2, target_col + 1, col2, target);  //checks bottom right array
                }
                if (target_col + 1 <= col2) {
                    find_target(arr, row, target_row, target_col + 1, col2, target);  //checks upper right array
                }
                if (target_row + 1 <= row2) {
                    find_target(arr, target_row + 1, row2, col, target_col, target);  //checks bottom left array
                }
            }
        }
    }
}

