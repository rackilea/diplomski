import java.util.Arrays;
import java.util.Comparator;


public class Foo {

    public static void main(String[] args) {

        String[] myArray = {"1c", "13d", "11d", "10d", "1h", "13h", "5s", "2s", "12d"};

        System.out.println(Arrays.toString(myArray));

        Arrays.sort(myArray, new Comparator<String>() {
            @Override
            public int compare(String one, String two) {

                int oneNum = Integer.parseInt(one.substring(0, one.length() - 1));
                int twoNum = Integer.parseInt(two.substring(0, two.length() - 1));

                char oneChar = one.charAt(one.length() - 1);
                char twoChar = two.charAt(two.length() - 1);

                if (oneNum < twoNum) {
                    return -1;
                } else if (oneNum == twoNum) {
                    if (oneChar < twoChar) {
                        return -1;
                    } else if (oneChar == twoChar){
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        }
    );

    System.out.println(Arrays.toString(myArray));   

    }

}