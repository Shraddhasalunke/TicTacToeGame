import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        boolean isPlayerX = true;

        while (true) {
            printBoard(board);
            int[] move = getInput(board, isPlayerX);
            int row = move[0];
            int col = move[1];

            if (board[row][col] == ' ') {
                board[row][col] = isPlayerX ? 'X' : 'O';
                isPlayerX = !isPlayerX;
            } else {
                System.out.println("Cell already taken. Try again.");
            }

            if (checkWin(board, 'X')) {
                printBoard(board);
                System.out.println("Player X wins!");
                break;
            } else if (checkWin(board, 'O')) {
                printBoard(board);
                System.out.println("Player O wins!");
                break;
            } else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
        System.out.println();
    }

    public static int[] getInput(char[][] board, boolean isPlayerX) {
        Scanner scanner = new Scanner(System.in);
        char symbol = isPlayerX ? 'X' : 'O';
        System.out.print("Player " + symbol + ", enter your move (row and column): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[] {row, col};
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
