import java.util.*;
public class IntArrays {
    public static void main(String[] args) {
        List<int[]> arList = new ArrayList<>();

        arList.add(new int[]{1,2});
        arList.add(new int[]{1,2,3,4});

        int n = (int)Math.random()*10;
        int [] a = new int[n];
        arList.add(a);
    }
}