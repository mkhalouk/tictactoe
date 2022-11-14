public class Board {
    
    // A board has 9 cells, 3 rows and 3 columns
    private char[][] board;

    public Board() {
        this.board = new char[3][3];
        // initialize the array
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                this.setBoard(row, col, ' ');
            }
        }
    }

    public void setBoard(int cellX, int cellY, char value) {
        this.board[cellX][cellY] = value;
    }

    public char getBoardXY(int cellX, int cellY) {
        return this.board[cellX][cellY];
    }

    public void printBoard() {
        for(int row = 0; row < board.length; row++) {
            System.out.println("+---+---+---+");
            for(int col = 0; col < board[0].length; col++) {
                // char c = this.getBoardXY(row, col);
                // System.out.println(this.getBoardXY(row, col));
                System.out.print("| " + this.getBoardXY(row, col) + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("+---+---+---+");
    }
}
