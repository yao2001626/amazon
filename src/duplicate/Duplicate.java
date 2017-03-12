//line 31 "../../amazon.lep"
package duplicate;

import java.util.HashMap;
import java.util.Scanner;

public class Duplicate {

//line 84 "../../amazon.lep"
    /**
     * Coordinate node class.
     */
    public static class cNode {
        int row, column;
        cNode next;

        /**
         * Default constructor.
         */
        public cNode() {
            this.row = 0;
            this.column = 0;
            this.next = null;
        }

        /**
         * Constructor with coordinates.
         */
        public cNode(int row, int column) {
            this.row = row;
            this.column = column;
            this.next = null;
        }

        /**
         * Calculates distance to another node
         */
        public int dist(cNode node) {
            return Math.abs(this.row - node.row) + Math.abs(this.column - node.column);
        }

    }
//line 39 "../../amazon.lep"

//line 140 "../../amazon.lep"
    /**
     * Inserts a coordinate node to a HashMap, 
     * and checks its distance with previous coordinates.
     * @param  map        the HashMap
     * @param  key        the integer key
     * @param  currentRow the index of current row
     * @param  dist       maximum distance
     * @return <tt>true</tt> only when it is square.
     */
    public static boolean insertAndCheck(HashMap<Integer, cNode> map, int key, cNode newNode, int currentRow, int dist) {
        if (map.containsKey(key)) { // already encountered
            cNode head = map.get(key);
            // remove nodes not in the past dist rows
            while (head != null && head.row < currentRow - dist) {
                head = head.next;
            }
            if (head == null) { // linked list empty
                head = newNode;
            } else { // linked list not empty
                cNode cursor = head;
                // check the distances with nodes in the linked list
                while (cursor.next != null) {
                    if (newNode.dist(cursor) <= dist) {
                        return true;
                    }
                    cursor = cursor.next;
                }
                // if found
                if (newNode.dist(cursor) <= dist) {
                    return true;
                }
                // insert to the tail
                cursor.next = newNode;
            }
            // update map
            map.put(key, head);
        } else { // not encounted yet
            map.put(key, newNode);
        }
        // not found
        return false;
    }
//line 41 "../../amazon.lep"

//line 120 "../../amazon.lep"
    /**
     * Checks if there are two elements in a matrix
     * with distance less than a given integer.
     */
    public static boolean hasDuplicateInDist(int[][] matrix, int dist) {
        int rows = matrix.length;
        HashMap<Integer, cNode> map = new HashMap<Integer, cNode>();
        // inserts and checks all elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (insertAndCheck(map, matrix[i][j], new cNode(i, j), i, dist)) {
                    return true;
                }
            }
        }
        return false;
    }
//line 43 "../../amazon.lep"

//line 70 "../../amazon.lep"
    /**
     * Outputs an integer matrix.
     * @param matrix the integer matrix
     */
    public static void outputMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + (j < matrix[i].length - 1 ? " " : ""));                
            }
            System.out.println();
        }
    }
//line 45 "../../amazon.lep"

//line 52 "../../amazon.lep"
    public static void main(String[] args) {
        // reads in rows, matrix, and dist
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(); // number of rows
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = new int[rows];
            for (int j = 0; j < rows; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int dist = sc.nextInt(); // maximum distantce
        sc.close();
        System.out.println(hasDuplicateInDist(matrix, dist) ? "YES" : "NO");
    }
//line 47 "../../amazon.lep"

}
