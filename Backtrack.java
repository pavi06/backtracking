public class Backtrack {
    public static void main(String[] args) {
        int n = 5;// board size
        boolean[][] board = new boolean[n][n];// creating board
        System.out.println(queens(board, 0));
    }

    // 3 function
    // 1.queens place
    // 2.to check for placement
    // 3.display board

    static int queens(boolean[][] board, int row) {
        if (row == board.length) { // if we reach end of the row length
            display(board);
            System.out.println();
            return 1;// found a sol. so return 1
        }

        int count = 0;

        // placing the queen and checking for every row and col
        for (int col = 0; col < board.length; col++) {
            // place the queen if it is safe
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);// checking for the next row
                board[row][col] = false;// backstrack step
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // checking the vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    // displaying the board
    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
