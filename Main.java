import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        // board.printBoard();:
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Player 1 choose your username : ");
        Player p1 = new Player(sc.nextLine());
        
        System.out.print("Player 2 choose your username : ");
        Player p2 = new Player(sc.nextLine());

        Game game = new Game();
        game.startGame(p1, p2, board);
        
    }
}
