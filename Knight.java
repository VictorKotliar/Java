
    import java.util.Scanner;

    public class Knight {
        public static void main(String[] args) {
            final int MIN = 1; // the final of min for easier usage
            final int MAX = 8; // and the final of max for easier usage in the code
    // Student: Victor aviv kotliar  , The program shows the moves that knight can move
            Scanner scan = new Scanner(System.in);
            System.out.println("This program reads two integers which " +
                    "represent the knight's location on the chess board: ");
            System.out.println("Please enter the number of row");
            int row = scan.nextInt();  // using scan to read users input
            System.out.println("Please enter the number of column");
            int col = scan.nextInt();  // using scan to read users input
    // main answer
     if (row >= MIN && row <= MAX && col >= MIN && col <= MAX) {
            System.out.println("Moves:");
            // Using the if to make sure its not - and not higher then row 8 or col 8
    // start of function Knight has 8 diffrent functions (1,2)(-1,2)(-2,1)(2,1)(-2,-1)(-1,-2)(1,-2)(2,-1) so the next 40 lines trying to math the functions to check if it can move
                // -2x + y
                row = row - 2;
                col = col + 1;
                if (row >= MIN && row <= MAX && col >= MIN && col <= MAX){
                    System.out.println(row + " " + col);
                }

                row = row + 2;
                col = col - 1;
                // -2x - y
                row = row - 2;
                col = col - 1;
                if (row >= MIN && row <= MAX && col >= MIN && col <= MAX){
                    System.out.println(row + " " + col);
                }

                    row = row + 2;
                    col = col + 1;
                // x -1 + 2 y
                row = row - 1;
                col = col + 2;
                if (row >= MIN && row <= MAX && col >= MIN && col <= MAX){
                    System.out.println(row + " " + col);
                }
                    row = row + 1;
                    col = col - 2;
                // x + 1  + 2y
                row = row + 1;
                col = col + 2;
                if (row >= MIN && row <= MAX && col >= MIN && col <= MAX){
                    System.out.println(row + " " + col);}
                    row = row - 1;
                    col = col- 2;
                // x + 1 - 2y
                row = row + 1;
                col = col- 2;
                if (row >= MIN && row <= MAX && col >= MIN && col <= MAX){
                    System.out.println(row + " " + col);
                }
                row = row - 1;
                col = col + 2;
                // x-- - 2y
                row = row - 1;
                col = col - 2;
                if (row >= MIN && row <= MAX && col >= MIN && col <= MAX){
                    System.out.println(row + " " + col);
                }
                row = row + 1;
                col = col+ 2;
                // + 2x  - y
                row = row + 2;
                col = col - 1;
                if (row >= MIN && row <= MAX && col >= MIN && col <= MAX){
                    System.out.println(row + " " + col);
                }
                row = row - 2;
                col = col + 1;
                // + 2x  + y
                row = row + 2;
                col = col + 1;
                if (row >= MIN && row <= MAX && col >= MIN && col <= MAX){
                    System.out.println(row + " " + col);
                }
                row = row - 2;
                col = col - 1;
            }else  System.out.println("input is ilegal");

        }// end of method main
    } //end of class Knight