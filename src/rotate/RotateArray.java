//line 437 "../../amazon.lep"
package rotate;

import java.util.*;

public class RotateArray {

//line 459 "../../amazon.lep"
    /**
      * Reads from input stream, and outputs the result of rotation.
      * Returns true when it is square, and false when not.
      */
    public static boolean inputRotateAndOutput() {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(); // number of rows
        int halfRows = rows / 2; // half number of rows
        int prev = 2, curr = 0, next = 1; // three row indices for rotation
        int[][] matrix = new int[3][]; // three rows
        String line = sc.nextLine(); // consumes the first link break
        String[] intStrings; // integers in the form of strings
        // initializes matrix
        for (int i = 0; i < 3; i++) {
            matrix[i] = new int[rows];
        }
        // inputs, rotates and outputs 
        for (int i = 0; i < rows; i++) { // row index
            line = sc.nextLine(); // reads in a line
            intStrings = line.split(" "); // split by spaces
            if (intStrings.length == rows) { // if still square
                if (i < halfRows) { // upper half
                    // area 4, shift up
                    for (int j = 0; j < i; j++) { // column index
                        matrix[prev][j] = Integer.parseInt(intStrings[j]);
                    }
                    // outputs the previous row
                    if (i > 0) {
                        for (int j = 0; j < rows; j++) { // column index
                            System.out.print(matrix[prev][j] + (j < rows - 1 ? " " : ""));                
                        }
                        System.out.println();
                    }
                    // area 1, shift right
                    for (int j = i; j < rows - i - 1; j++) { // column index
                        matrix[curr][j + 1] = Integer.parseInt(intStrings[j]);
                    }
                    // area 2, shift down
                    for (int j = rows - i - 1; j < rows; j++) { // column index
                        matrix[next][j] = Integer.parseInt(intStrings[j]);
                    }
                } else if (i > rows - halfRows - 1)  { // lower half
                    // area 4, shift up
                    for (int j = 0; j < rows - i; j++) { // column index
                        matrix[prev][j] = Integer.parseInt(intStrings[j]);
                    }
                    // outputs the previous row
                    if (i > 0) {
                        for (int j = 0; j < rows; j++) { // column index
                            System.out.print(matrix[prev][j] + (j < rows - 1 ? " " : ""));                
                        }
                        System.out.println();
                    }
                    // area 3, shift left
                    for (int j = rows - i; j < i + 1; j++) { // column index
                        matrix[curr][j - 1] = Integer.parseInt(intStrings[j]);
                    }
                    // area 2, shift down
                    for (int j = i + 1; j < rows; j++) { // column index
                        matrix[next][j] = Integer.parseInt(intStrings[j]);
                    }                    
                } else { // mid row
                    for (int j = 0; j < halfRows; j++) {
                        // area 4, shift up
                        matrix[prev][j] = Integer.parseInt(intStrings[j]);
                    }
                    // outputs the previous row
                    if (i > 0) {
                        for (int j = 0; j < rows; j++) { // column index
                            System.out.print(matrix[prev][j] + (j < rows - 1 ? " " : ""));                
                        }
                        System.out.println();
                    }
                    // area 5, no shift
                    matrix[curr][i] = Integer.parseInt(intStrings[i]);
                    for (int j = halfRows + 1; j < rows; j++) {
                        // area 2, shift down
                        matrix[next][j] = Integer.parseInt(intStrings[j]);
                    }
                }
            } else {
                sc.close();
                return false;
            }
            // rotates the rows
            curr = next;
            next = prev;
            prev = 3 - curr - next;
        }
        // outputs the last row
        for (int j = 0; j < rows; j++) { // column index
            System.out.print(matrix[prev][j] + (j < rows - 1 ? " " : ""));                
        }
        System.out.println();
        sc.close();
        return true;
    }
//line 444 "../../amazon.lep"

//line 451 "../../amazon.lep"
    public static void main(String[] args) {
        if (!inputRotateAndOutput()) {
            System.out.println("ERROR");
        }
    }
//line 446 "../../amazon.lep"

}
