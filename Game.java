import java.util.ArrayList;

import java.util.Arrays;
import java.util.Map;
import java.util.ArrayList;

public class Game {
    final ArrayList<int[]> winningCombo = new ArrayList<int[]>(
        Arrays.asList(
            new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}, // horizontal
            new int[]{1,4,7}, new int[]{2,5,8}, new int[]{3,6,9}, // vertical
            new int[]{1,5,9}, new int[]{3,5,7} // diagonal
        )
    );

    Game() {

    }

    public void startGame() {

    }

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
