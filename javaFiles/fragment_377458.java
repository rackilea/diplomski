import java.util.StringTokenizer;

public class Temp {
    public static void main(String[] args) {
        String s = "My name is Sugandha";
        int i = 0;

        StringTokenizer s1 = new StringTokenizer(s, " ");

        String[] ar = new String[s1.countTokens()];

        while (s1.hasMoreTokens()) {
            ar[i++] = s1.nextToken();
        }

        for(int j= 0 ;j<ar.length;j++){
            System.out.println(ar[j]);
        }
    }
}