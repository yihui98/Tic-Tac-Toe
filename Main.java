package tictactoe;
import java.util.Scanner;


public class Main {
    public static <Char> void main(String[] args) {
        String cells = "123456789";
        char[][] board = creategrid(cells.toCharArray());
        System.out.println(Character.toString(board[1][1]));
        grid(board);
        int a=  0;

        while(!check(board)) {
            if (a==9){
                System.out.println("It's a draw!");
                System.exit(0);
            }
            if (a % 2 == 0) {
                char token = 'O';
                System.out.println(Character.toString(token) + "'s turn");
                System.out.println("Please input a number!");
                Scanner input = new Scanner(System.in);
                int num = input.nextInt();
                int x = Math.floorDiv(num, 3);
                int y = num - x * 3;
                if (y == 0) {
                    x = x - 1;
                    y = 2;
                    board[x][y] = token;
                    a++;
                } else {
                    board[x][y - 1] = token;
                    a++;
                }
            }
            else{
                    char token = 'X';
                    System.out.println(Character.toString(token) + "'s turn");
                    System.out.println("Please input a number!");
                    Scanner input = new Scanner(System.in);
                    int num = input.nextInt();
                    int x = Math.floorDiv(num, 3);
                    int y = num - x * 3;
                    if (y == 0) {
                        x = x - 1;
                        y = 2;
                        board[x][y] = token;
                        a++;
                    } else {
                        board[x][y - 1] = token;
                        a++;
                    }
                }
            grid(board);

            }

        }

    public static boolean check(char[][] board) {
        for (int r = 0; r < 3; r++) {
            if (board[r][0] == board[r][1] && board[r][1] == board[r][2] && board[r][0] != '-')
                if (board[r][0] == 'X') {
                    System.out.println("X wins");
                    return true;
                } else if (board[r][0] == 'O') {
                    System.out.println("O wins");
                    return true;
                }
        }
        //loops through columns checking if win-condition exists
        for (int c = 0; c < 3; c++) {
            if (board[0][c] == board[1][c] && board[1][c] == board[2][c] && board[0][c] != '-')
                if (board[c][0] == 'X') {
                    System.out.println("X wins");
                    return true;
                } else if (board[c][0] == 'O') {
                    System.out.println("O wins");
                    return true;
                }
        }
        //checks diagonals for win-condition
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-')
            if (board[0][0] == 'X') {
                System.out.println("X wins");
                return true;
            } else if (board[0][0] == 'O') {
                System.out.println("O wins");
                return true;
            }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][0] != '-')
            if (board[0][2] == 'X') {
                System.out.println("X wins");
                return true;
            } else if (board[0][2] == 'O') {
                System.out.println("O wins");
                return true;
            }
        return false;
    }

    public static void grid(char[][] board) {
        System.out.println("---------");
        int a = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int x = 0; x < 3; x++) {
                System.out.print(" ");
                System.out.print(board[a][x]);
            }
            a++;
            System.out.print(" ");
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("---------");
    }

    public static char[][] creategrid(char[] input) {
        int a = 0;
        char[][] grid = new char[3][3];
        for (int x = 0; x < 3; x++) {
            for (int i = 0; i < 3; i++) {
                grid[a][i] = input[a * 3 + i];
            }
            a++;
        }
        return grid;
    }
}
