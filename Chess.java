import java.util.Scanner;

public class Chess { // Name: Victor Aviv Kotliar ,  ... Class Chess reads input to the decide which Soldeirs are on the board where are they , who can attack first ,check if the first attack is working and if not checks if the second piece can attack
    public static void main(String[] args) {
        final int MIN = 1; // the final of min for easier usage
        final int MAX = 8; // and the final of max for easier usage in the code

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the type" + " of the first chessman"); // The program starts with asking the x + Y or both of our soldier
        char first = scan.next().charAt(0); // using scan to read users input
        System.out.println("Please enter the number of row");// x 1
        int row1 = scan.nextInt(); // using scan to read users input
        System.out.println("Please enter the number of column");// y 1
        int col1 = scan.nextInt();  // using scan to read users input
        System.out.println("Please enter the type" + " of the second chessman");// What soldier is the second one
        char second = scan.next().charAt(0); // using scan to read users input
        System.out.println("Please enter the number of row"); // x 2
        int row2 = scan.nextInt(); // using scan to read users input
        System.out.println("Please enter the number of column");// y 2
        int col2 = scan.nextInt(); // using scan to read users input
        if (row1 >= MIN && row1 <= MAX && col1 >= MIN && col1 <= MAX && row2 >= MIN && row2 <= MAX && col2 >= MIN && col2 <= MAX) { // the if checks to make sure x,y isnt below 0 and not above 8
            switch (first) { // starting off with Switch which starts a tree of possible moves and what charcters go first and second
                case 'r': // in that case it checks for first=='r'
                    System.out.println(first + " " + row1 + " " + col1); //prints the name of first\second aswell as printing the x,y
                    System.out.println(second + " " + row2 + " " + col2);
                    switch (second) {
                        case 'b': { // incase first = r and second = b
                            if ((row1 == row2) && (col1 != col2) || (col1 == col2) && (row1 != row2)) { // Rook attack when ever x=x and y=y so we check it of from the start since it goes first
                                System.out.println("rook threats bishop");//incase of it works
                            } else if (Math.abs(row1 - row2) == Math.abs(col1 - col2)) { //if the Rook attack wasn't successful it checks if second which is Bishop can attack
                                // bishops moves are equal to this fomula |x-x|=|y-y|
                                System.out.println("bishop threats rook"); //incase the second one attacks and works
                            } else System.out.println("no threat"); // case 3 nothing attacks
                            break; //using break to stop the program to keep working after reaching the end
                        }
                        case 'k': {
                            if (row1 == row2 || col1 == col2) { // to threat the Knight Rook needs to Be either on the same row or on the same col ofc being on both is impossible
                                System.out.println("rook threat knight ");
                                break;
                            } else { // Knight has 8 diffrent functions (1,2)(-1,2)(-2,1)(2,1)(-2,-1)(-1,-2)(1,-2)(2,-1) so the next 40 lines is basicaly trying to math the functions to check if it can attack
                                // -2x + y
                                row1 = row1 - 2;
                                col1 = col1 + 1;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 + 2;
                                col1 = col1 - 1;
                                // -2x - y
                                row1 = row1 - 2;
                                col1 = col1 - 1;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 + 2;
                                col1 = col1 + 1;
                                // x -1 + 2 y
                                row1 = row1 - 1;
                                col1 = col1 + 2;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 + 1;
                                col1 = col1 - 2;
                                // x + 1  + 2y
                                row1 = row1 + 1;
                                col1 = col1 + 2;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 - 1;
                                col1 = col1 - 2;
                                // x + 1 - 2y
                                row1 = row1 + 1;
                                col1 = col1 - 2;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 - 1;
                                col1 = col1 + 2;
                                // x-- - 2y
                                row1 = row1 - 1;
                                col1 = col1 - 2;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 + 1;
                                col1 = col1 + 2;
                                // + 2x  - y
                                row1 = row1 + 2;
                                col1 = col1 - 1;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 - 2;
                                col1 = col1 + 1;
                                // + 2x  + y
                                row1 = row1 + 2;
                                col1 = col1 + 1;
                            }
                            {
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");

                                    row1 = row1 - 2;
                                    col1 = col1 - 1;
                                    break;
                                } else System.out.println("no threat");
                                break;
                            }
                        }
                    }
                    break;
                case 'b': {// first
                    System.out.println(first + " " + row1 + " " + col1);
                    System.out.println(second + " " + row2 + " " + col2);
                    switch (second) {
                        case 'r': { //second
                            {
                                if (Math.abs(row1 - row2) == Math.abs(col1 - col2)) { // bishops moves are equal to this formula |x-x|=|y-y|
                                    System.out.println("bishop threats rook");
                                    break;
                                }
                                if (col1 == col2 && row1 != row2 || col1 != col2 && row1 == row2) {
                                    System.out.println("rook threats bishop");
                                    break; // using Rooks formula to check if he has chances even if he is second
                                } else if (col1 != col2 && row1 != row2 || col1 != col2 && row1 != row2) {
                                    System.out.println("no threat"); // after checking both chessmen we can be sure that there was no threat between them
                                    break;
                                }
                                break;
                            }
                        }
                        case 'k': {//second
                            if (Math.abs(row1 - row2) == Math.abs(col1 - col2)) { //again bishop formula to check if he can attack as he is the first one to move
                                System.out.println("bishop threats knight");
                                break;
                            }
                            if (Math.abs(row1 - row2) != Math.abs(col1 - col2)) { // iv used this if to follow up to the second section which is second attacks first
                                // -2x + y ofc we have same 40 lines of code that copies the Knight movements
                                row1 = row1 - 2;
                                col1 = col1 + 1;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 + 2;
                                col1 = col1 - 1;
                                // -2x - y
                                row1 = row1 - 2;
                                col1 = col1 - 1;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 + 2;
                                col1 = col1 + 1;
                                // x -1 + 2 y
                                row1 = row1 - 1;
                                col1 = col1 + 2;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 + 1;
                                col1 = col1 - 2;
                                // x + 1  + 2y
                                row1 = row1 + 1;
                                col1 = col1 + 2;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 - 1;
                                col1 = col1 - 2;
                                // x + 1 - 2y
                                row1 = row1 + 1;
                                col1 = col1 - 2;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 - 1;
                                col1 = col1 + 2;
                                // x-- - 2y
                                row1 = row1 - 1;
                                col1 = col1 - 2;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 + 1;
                                col1 = col1 + 2;
                                // + 2x  - y
                                row1 = row1 + 2;
                                col1 = col1 - 1;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    break;
                                } else row1 = row1 - 2;
                                col1 = col1 + 1;
                                // + 2x  + y
                                row1 = row1 + 2;
                                col1 = col1 + 1;
                                if (row1 == row2 && col1 == col2) {
                                    System.out.println("knight threats bishop");
                                    row1 = row1 - 2;
                                    col1 = col1 - 1;

                                    break;
                                } else System.out.println("no threat");
                            }
                        }
                    }
                }
                break;
                case 'k': // first
                    switch (second) {
                        case 'r': { // knight formula
                            // -2x + y
                            row1 = row1 - 2;
                            col1 = col1 + 1;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats rook");
                                break;
                            } else if (row1 != row2 && col1 != col2) row1 = row1 + 2;
                            col1 = col1 - 1;
                            // -2x - y
                            row1 = row1 - 2;
                            col1 = col1 - 1;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats rook");
                                break;
                            } else row1 = row1 + 2;
                            col1 = col1 + 1;
                            // x -1 + 2 y
                            row1 = row1 - 1;
                            col1 = col1 + 2;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats rook");
                                break;
                            } else row1 = row1 + 1;
                            col1 = col1 - 2;
                            // x + 1  + 2y
                            row1 = row1 + 1;
                            col1 = col1 + 2;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats rook");
                                break;
                            } else row1 = row1 - 1;
                            col1 = col1 - 2;
                            // x + 1 - 2y
                            row1 = row1 + 1;
                            col1 = col1 - 2;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats rook");
                                break;
                            } else row1 = row1 - 1;
                            col1 = col1 + 2;
                            // x-- - 2y
                            row1 = row1 - 1;
                            col1 = col1 - 2;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats rook");
                                break;
                            } else row1 = row1 + 1;
                            col1 = col1 + 2;
                            // + 2x  - y
                            row1 = row1 + 2;
                            col1 = col1 - 1;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats rook");
                                break;
                            } else row1 = row1 - 2;
                            col1 = col1 + 1;
                            // + 2x  + y
                            row1 = row1 + 2;
                            col1 = col1 + 1;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats rook");
                                break;
                            }
                            row1 = row1 - 2;
                            col1 = col1 - 1;
                        }
                        if (col1 == col2 && row1 != row2 || col1 != col2 && row1 == row2) {
                            System.out.println("rook threats knight");
                            break;
                        } else if ((col1 != col2 && row1 != row2 || col1 != col2 && row1 != row2)) { //Rook formula
                            System.out.println("no threat"); // both lost
                            break;
                        }

                        // case b is second with K being first
                        case 'b': { // Knight formula
                            // -2x + y
                            row1 = row1 - 2;
                            col1 = col1 + 1;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats bishop");
                                break;
                            } else row1 = row1 + 2;
                            col1 = col1 - 1;
                            // -2x - y
                            row1 = row1 - 2;
                            col1 = col1 - 1;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats bishop");
                                break;
                            } else row1 = row1 + 2;
                            col1 = col1 + 1;
                            // x -1 + 2 y
                            row1 = row1 - 1;
                            col1 = col1 + 2;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats bishop");
                                break;
                            } else row1 = row1 + 1;
                            col1 = col1 - 2;
                            // x + 1  + 2y
                            row1 = row1 + 1;
                            col1 = col1 + 2;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats bishop");
                                break;
                            } else row1 = row1 - 1;
                            col1 = col1 - 2;
                            // x + 1 - 2y
                            row1 = row1 + 1;
                            col1 = col1 - 2;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats bishop");
                                break;
                            } else row1 = row1 - 1;
                            col1 = col1 + 2;
                            // x-- - 2y
                            row1 = row1 - 1;
                            col1 = col1 - 2;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats bishop");
                                break;
                            } else row1 = row1 + 1;
                            col1 = col1 + 2;
                            // + 2x  - y
                            row1 = row1 + 2;
                            col1 = col1 - 1;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats bishop");
                                break;
                            } else row1 = row1 - 2;
                            col1 = col1 + 1;
                            // + 2x  + y
                            row1 = row1 + 2;
                            col1 = col1 + 1;
                            if (row1 == row2 && col1 == col2) {
                                System.out.println("knight threats bishop");
                                break;
                            } else row1 = row1 - 2;
                            col1 = col1 - 1;
                        }
                        if (Math.abs(row1 - row2) == Math.abs(col1 - col2)) { // Bishop formula for the end to check if he can attack second
                            System.out.println("bishop threats knight");

                        } else System.out.println("no threat");
                    }

                    break;
            }
        } else {
            System.out.println("Position is not legal");
        } // a solution for users that enter wrong positions lower then 0 and higher then 8
    }// end of method main
}// end of class Chess
