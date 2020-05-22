public class Test {

 public static void main(String[] args) {

            String str = "1 * 2 3 / 4 5 6";
            String[] arr = str.split(" ", str.length());

            for (int i=0;i < arr.length;i++)
                System.out.println(arr[i] + "is diggit? " + arr[i].matches("-?\\d+(\\.\\d+)?"));

        }
    }