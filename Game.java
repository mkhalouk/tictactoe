import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Game {
    // final ArrayList<int[]> winningCombo = new ArrayList<int[]>(
    //     Arrays.asList(
    //         new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}, // horizontal
    //         new int[]{1,4,7}, new int[]{2,5,8}, new int[]{3,6,9}, // vertical
    //         new int[]{1,5,9}, new int[]{3,5,7} // diagonal
    //     )
    // );

    // final Integer[][] winningCombo = new Integer[][] {
    //     new Integer[]{1,2,3}, new Integer[]{4,5,6}, new Integer[]{7,8,9}, // horizontal
    //     new Integer[]{1,4,7}, new Integer[]{2,5,8}, new Integer[]{3,6,9}, // vertical
    //     new Integer[]{1,5,9}, new Integer[]{3,5,7} // diagonal
    // };
    List<Integer[]> winningCombo;

    Game() {
        this.winningCombo = new ArrayList<>(
            Arrays.asList(
                new Integer[]{1,2,3}, new Integer[]{4,5,6}, new Integer[]{7,8,9}, // horizontal
                new Integer[]{1,4,7}, new Integer[]{2,5,8}, new Integer[]{3,6,9}, // vertical
                new Integer[]{1,5,9}, new Integer[]{3,5,7} // diagonal
            )
        );
    }

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
        board.printBoard();

        // Game is playing
        while(true) {
            if(board.isBoardFull()) {
                break;
            }
            
            this.playTurn(p1, board, sc);
            if(this.continueGame(p1, board, sc))
                board.initialize();

            this.playTurn(p2, board, sc);
            if(this.continueGame(p2, board, sc)) {
                board.initialize();
                board.printBoard();
            }
        }
        sc.close();

        System.out.println("Game over, here are your scores :");
        System.out.println(username_p1 + " : " + p1.getScore());
        System.out.println(username_p2 + " : " + p2.getScore());
    }

    public void playTurn(Player p, Board board, Scanner sc) {
        System.out.println(p.getUsername() + " your turn to play");
        System.out.print("Select the cell number to put your symbol : ");
        int cell = Integer.parseInt(sc.nextLine());
        if (board.isCellAvailable(cell)) {
            board.setCellValue(cell, p.getSymbol());
        } else {
            System.out.println(p.getUsername() + " cell not available");
            System.out.print("Select the cell number to put your symbol : ");
            cell = Integer.parseInt(sc.nextLine());
        }

        board.printBoard();
    }

    public boolean won(Player player, Board board) {
        String symbol = player.getSymbol();
        ArrayList<Integer> occurrences = new ArrayList<Integer>();
        boolean won = false;

        for(String[] value : (board.getBoard()).values()) {
            if(value[0].equals(symbol))
                occurrences.add(Integer.valueOf(value[1]));// index 0 = symbol & index 1 = cell
        }

        for(Integer[] values : this.winningCombo) {
            if (
                IntStream.of(Utils.toArray(occurrences)).anyMatch(x -> x == values[0]) && 
                IntStream.of(Utils.toArray(occurrences)).anyMatch(x -> x == values[1]) && 
                IntStream.of(Utils.toArray(occurrences)).anyMatch(x -> x == values[2])
                ) {
                    won = true;
                    player.setScore(player.getScore() + 1);
                    System.out.println(player.getUsername() + " has won this round!");
            }
        }

        return won;
    }

    public boolean continueGame(Player p, Board board, Scanner sc) {
        if(board.isBoardFull() || this.won(p, board)) {
            System.out.println("Do want to have a rematch?");
            return this.rematch(sc.nextLine());
        }
        return false;
    }

    public boolean rematch(String string) {
        return (string.equals("y") || string.equals("Y"));
    }
}
