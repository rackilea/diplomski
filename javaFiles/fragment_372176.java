import java.util.*;

public class Main {
public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    Map<Integer, String> myMap = new HashMap<>();
    myMap.put(1, "a");
    myMap.put(2, "b");
    myMap.put(3, "c");
    myMap.put(4, "d");
    myMap.put(5, "e");
    myMap.put(6, "f");
    myMap.put(7, "g");
    myMap.put(8, "h");
    myMap.put(9, "i");
    myMap.put(10, "j");
    myMap.put(11, "k");
    myMap.put(12, "l");
    myMap.put(13, "m");
    myMap.put(14, "n");
    myMap.put(15, "o");
    myMap.put(16, "p");
    myMap.put(17, "q");
    myMap.put(18, "r");
    myMap.put(19, "s");
    myMap.put(20, "t");
    myMap.put(21, "u");
    myMap.put(22, "v");
    myMap.put(23, "w");
    myMap.put(24, "x");
    myMap.put(25, "y");
    myMap.put(26, "z");

    Scanner in = new Scanner(System.in);
    System.out.println("Enter limit here [input type: integer]\n");
    int lim = in.nextInt();
    String[] arr = new String[26 * lim];
    int i = 0;
    int j = lim;
    int k = 1;
    while (i < arr.length) {
        while (lim > 0) {
            arr[i] = myMap.get(k);
            lim--;
            i++;
        }
        lim = j;
        k++;
    }
    print_nCr(arr,arr.length, lim);
}

public static final void print_nCr(String[] arr,final int n, final int r) {
    int[] res = new int[r];
    for (int i = 0; i < res.length; i++) {
        res[i] = i + 1;
    }
    boolean done = false;
    while (!done) {
        for(int i=0;i<res.length;i++){
            System.out.print(arr[res[i]-1]);
        }
        System.out.print("\n");
        done = getNext(res, n, r);
    }
}
public static final boolean getNext(final int[] num, final int n, final int r) {
    int target = r - 1;
    num[target]++;
    if (num[target] > ((n - (r - target)) + 1)) {
        while (num[target] > ((n - (r - target)))) {
            target--;
            if (target < 0) {
                break;
            }
        }
        if (target < 0) {
            return true;
        }
        num[target]++;
        for (int i = target + 1; i < num.length; i++) {
            num[i] = num[i - 1] + 1;
        }
    }
    return false;
}

}