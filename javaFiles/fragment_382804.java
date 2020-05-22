import java.util.Arrays;
public class newInsertionSort {

    int[] ages; //= {19, 20, 19, 80, 45, 5, 51};
    String[] names;

    void InsertionSort() {
        for (int i = 1; i < ages.length; i++) {
            int j = i;
            while (j>0 && ages[j] < ages[j - 1]) {
                int temp = ages[j];
                ages[j] = ages[j - 1];
                ages[j - 1] = temp;
                //add code to change the order of the names
                String temporary = names[j];
                names[j] = names [j-1];
                names [j-1] = temporary;
                j--;
            }
        }
        System.out.println(Arrays.toString(ages));
        System.out.println(Arrays.toString(names));
    }
}

class newInsertionSortTest {
    public static void main (String[] args){
        newInsertionSort sort = new newInsertionSort(); // Changed code here
        sort.ages = new int[] {19, 20, 19, 80, 45, 5, 51};
        sort.names = new String[] {"a", "b", "c", "d", "e", "f", "g"};
        sort.InsertionSort();
    }
}