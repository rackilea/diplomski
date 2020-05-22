import java.util.Arrays;

public class OtherNameThanArrays {

    public static void main(String[] args) {

        int[] numbers = new int[5];

        numbers[0] = 31;
        numbers[1] = 88;
        numbers[2] = 11;
        numbers[3] = 73;
        numbers[4] = 45;

        int[] numbers2 = {99, 1, 2, 3, 4};

        Arrays.sort(numbers);
        Arrays.sort(numbers2);

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(numbers2));
    }


}