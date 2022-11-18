import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Board {
    
    // A board has 9 cells, 3 rows and 3 columns
    // Each cell is represented from 1 to 9 horizontally
    // In the hashmap the String[] represents the tuple [symbol, cell index]
    private HashMap<Integer, String[]> board = new HashMap<Integer, String[]>();

    public Board() {
        // initialize the array
        // we print the numbers of the corresponding cell in the cell in order to give the user the info where to put its symbol
        for(int cell = 1; cell <= 3*3; cell++) {
            this.addToBoard(cell, Integer.toString(cell));
        }
    }

    public HashMap<Integer, String[]> getBoard() {
        return board;
    }

    public void addToBoard(int cell, String value) {
        (this.getBoard()).put(Integer.valueOf(cell), new String [] {value, Integer.toString(cell)});
    }

    public String getCellValue(int cell) {
        return (this.getBoard()).get(Integer.valueOf(cell))[0]; // at index 0 we have the symbol
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
        ArrayList<String> occurrences = new ArrayList<String>();
        for(String[] value : (this.getBoard()).values()) {
            occurrences.add(value[0]); // at index 0 we have the symbol
        }

        return (new HashSet<String>(occurrences).size() == 2);
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
