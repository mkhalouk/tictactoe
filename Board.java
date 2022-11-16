import java.util.HashMap;
import java.util.HashSet;

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

    // Only authorized values : X or O
    public boolean setCellValue(int cell, String value) {
        if(value.equals("X") || value.equals("O")) {
            this.addToBoard(cell, value);
            return true;
        } 
        System.out.println("You need to choose between X or O");
        return false;
    }

    // In order to be available, a cell has to be different than X and O
    public boolean isCellAvailable(int cell) {
        return !((this.getCellValue(cell)).equals("X")) && !((this.getCellValue(cell)).equals("O"));
    }

    // Test if all cells have been written
    public boolean isBoardFull() {
        return (new HashSet<String>(this.board.values()).size() == 2);
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
