import java.util.ArrayList;

public class Utils {
    public static int[] toArray(ArrayList<Integer> array) {
        return array.stream().mapToInt(i -> i).toArray();
    }
}
