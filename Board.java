import java.util.HashMap;

public class Board {
    
    // A board has 9 cells, 3 rows and 3 columns
    // Each cell is represented from 1 to 9 horizontally
    private HashMap<Integer, String> board = new HashMap<Integer, String>();

    public Board() {
        // initialize the array
        // we print the numbers of the corresponding cell in the cell in order to give the user the info where to put its symbol
        for(int cell = 1; cell <= 3*3; cell++) {
            this.addToBoard(cell, Integer.toString(cell));
        }
    }

    public HashMap<Integer, String> getBoard() {
        return board;
    }

    public void addToBoard(int cell, String value) {
        this.board.put(Integer.valueOf(cell), value);
    }

    public String getCellValue(int cell) {
        return this.board.get(Integer.valueOf(cell));
    }

    public void setCellValue(int cell, String value) {
        this.addToBoard(cell, value);
    }

    public void printBoard() {
        System.out.println("+---+---+---+");
        for(int cell = 1; cell <= 3*3; cell++) {
            System.out.print("| " + this.getCellValue(cell) + " ");
            if (cell % 3 == 0) {
                System.out.print("|\n");
                System.out.println("+---+---+---+");
            }
        }
    }
}
