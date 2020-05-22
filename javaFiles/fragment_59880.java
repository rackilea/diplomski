import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        String s = "gggggeeksfooorrrrgggeeeeksssss";
        removeDuplicate(s, 0);
    }

    public static void removeDuplicate(String d, int i) {
        int n = d.length();
        if (i >= n-1){
            System.out.println(d);
        } else if (d.charAt(i) == d.charAt(i + 1)) {
            d = d.substring(0, i) + d.substring(i + 1);
            removeDuplicate(d, i);
        } else{
            i = i + 1;
            removeDuplicate(d, i);
        }
    }
}