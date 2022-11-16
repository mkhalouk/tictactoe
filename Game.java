import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    final ArrayList<int[]> winningCombo = new ArrayList<int[]>(
        Arrays.asList(
            new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}, // horizontal
            new int[]{1,4,7}, new int[]{2,5,8}, new int[]{3,6,9}, // vertical
            new int[]{1,5,9}, new int[]{3,5,7} // diagonal
        )
    );

    public void startGame(Player p1, Player p2, Board board) {
        Scanner sc = new Scanner(System.in);

        String username_p1 = p1.getUsername();
        String username_p2 = p2.getUsername();

        // We set the symbol for player one by user input and then we affect the second one by deduction
        while(true) {
            System.out.println(username_p1 + " select your symbol (X or O)");
            String symbol = sc.nextLine();
            if (symbol.equals("X") || symbol.equals("O")) {
                p1.setSymbol(sc.nextLine());
                break;
            }
            System.out.println("Choice not valid.");
        }

        if((p1.getSymbol()).equals("X")) {
            p2.setSymbol("O");
        } else {
            p2.setSymbol("X");
        }

        System.out.println(username_p1 + " is " + p1.getSymbol());
        System.out.println(username_p2 + " is " + p2.getSymbol());

        while(true) { // TODO edit the true condition and put the win condition
            board.printBoard();
            
            // TODO Refactor this code
            System.out.println(username_p1 + " your turn to play");
            System.out.print("Select the cell number to put your symbol : ");
            int cell = Integer.parseInt(sc.nextLine());
            if (board.isCellAvailable(cell)) {
                board.setCellValue(cell, p1.getSymbol());
            } else {
                System.out.println(username_p1 + " cell not available");
                System.out.print("Select the cell number to put your symbol : ");
                cell = Integer.parseInt(sc.nextLine());
            }
            board.printBoard();
            if(board.isBoardFull()) {
                break;
            }
            
            System.out.println(username_p2 + " your turn to play");
            System.out.print("Select the cell number to put your symbol : ");
            cell = Integer.parseInt(sc.nextLine());
            if (board.isCellAvailable(cell)) {
                board.setCellValue(cell, p2.getSymbol());
            } else {
                System.out.println(username_p2 + " cell not available");
                System.out.print("Select the cell number to put your symbol : ");
                cell = Integer.parseInt(sc.nextLine());
            }
            board.printBoard();
            if(board.isBoardFull()) {
                break;
            }
        }
        sc.close();
        p1.setScore(0);
        p2.setScore(1);

        System.out.println("Game over, here are your scores :");
        System.out.println(username_p1 + " : " + p1.getScore());
        System.out.println(username_p2 + " : " + p2.getScore());
    }

    // TODO check if a player has won  
    // public boolean won(Board board) {
    //     ArrayList<int[]> keysX = new ArrayList<int[]>();
    //     (board.getBoard()).forEach((key,val) -> {
    //         if (val.equals("X")) {
    //             keysX.add(key);
    //         }
    //   });
    //     return false;
    // }
}
