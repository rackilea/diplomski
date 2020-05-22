import java.util.Arrays;
import java.util.StringTokenizer;

public class test {

    public static void main(String[] args) {

        String[] sizes = {"90 60 90", "90 70 60"};
        StringTokenizer st = new StringTokenizer(sizes[0]);
        int[] sizesInt = new int[6];
        sizesInt[0] = Integer.parseInt(st.nextToken());
        sizesInt[1] = Integer.parseInt(st.nextToken());
        sizesInt[2] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(sizes[1]);
        sizesInt[3] = Integer.parseInt(st.nextToken());
        sizesInt[4] = Integer.parseInt(st.nextToken());
        sizesInt[5] = Integer.parseInt(st.nextToken());

        System.out.println("sizesInt: " + Arrays.toString(sizesInt));

    }

}