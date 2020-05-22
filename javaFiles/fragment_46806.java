package CS1301;

public class Homework4 {

    public static void Questions(int value) {
        if (value > 0) {
            int count = 1;

            while (count <= value) {
                if (value % count == 0) {
                    System.out.println(count);
                }  

                count = count ++;
            }
        }
    }

    public static void main(String[] args) {
        Questions(5);
    }
}