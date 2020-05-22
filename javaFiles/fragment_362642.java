import java.util.Arrays;

/**
 *
 * @author Chirag
 */
public class Sampleh {

    private static final String[][] $DATA = new String[][]{
        {"New Delhi", "5000"},
        {"Chennai", "4300"},
        {"Goa", "2940"},
        {"New Delhi", "2003"},
        {"Kolkata", "8904"},
        {"Kerala", "8972"},
        {"New Delhi", "8922"},
        {"Chennai", "8217"},
        {"New Delhi", "2462"},
        {"Kolkata", "5564"},
        {"Kerala", "9934"},
        {"New Delhi", "100"},
        {"Kolkata", "892"},
        {"Kerala", "9406"},
        {"New Delhi", "2003"},
        {"Chennai", "1049"}
    };

    private static String[][] $result = new String[50][2];

    private static void action1() {
        outer:
        for (int i = 0; i < $DATA.length; i++) {
            String curCity = $DATA[i][0];
            Integer curProd = Integer.valueOf($DATA[i][1]);
            for (String[] city : $result) {
                if (city[0] == null) {
                    //for this loop
                    continue;
                }
                if (city[0].equals(curCity)) {
                    //for outer loop;
                    continue outer;
                }
            }
            for (int k = i; k < $DATA.length; k++) {
                if ($DATA[k][0].equals(curCity)) {
                    String n = $DATA[k][1];
                    if (n == null) {
                        n = "0";
                    }
                    curProd += Integer.valueOf(n);
                }
            }
            $result[i][0] = curCity;
            $result[i][1] = "" + curProd;
        }
        {
            //this code removes nulls from result array
            String[][] temp; //a temparory 2d array
            int counter = 0; //counts the num of values excluding nulls
            for (String[] res : $result) {
                if (res[0] == null) {
                    continue;
                }
                ++counter;
            }
            temp = new String[counter][2]; //redefine the temporary 2d array with size of values
            counter = 0;
            for (String[] res : $result) {
                if (res[0] == null) {
                    continue;
                }
                temp[counter][0] = res[0];
                temp[counter][1] = res[1];
                counter++;
            }
            $result = temp; //copy all values from temporary array to global result array
        }

        //prints the final array which is not sorted
        for (String[] r : $result) {
            System.out.println("City " + r[0] + " have " + r[1] + " products");
        }
    }

    private static void action2() {
        String[] cities = new String[$result.length];
        int[] products = new int[$result.length];
        int[] prodCopy = new int[$result.length];

        for (int i = 0; i < $result.length; i++) {
            cities[i] = $result[i][0];
            prodCopy[i] = Integer.valueOf($result[i][1]);
            products[i] = Integer.valueOf($result[i][1]);
        }

        Arrays.sort(products);

        for (int i = 0; i < products.length; i++) {
            int counter = -1;
            for (int p : prodCopy) {
                ++counter;
                if (p == products[i]) {
                    break; //breaks the loop to continue to other code without increasing counter
                }
            }
            $result[i][0] = cities[counter];
            $result[i][1] = "" + prodCopy[counter];
        }

        System.out.println("\nprinting full list sorted as counting of product");
        for (String[] k : $result) {
            System.out.println("City: " + k[0] + " have products " + k[1]);
        }

        int loc = $result.length - 2;
        System.out.println();
        System.out.println("Second highest City is '" + $result[loc][0] + "' having products '" + $result[loc][1] + "'");
        System.out.println();
    }

    public static void main(String... $results) {
        action1();
        action2();
    }
}