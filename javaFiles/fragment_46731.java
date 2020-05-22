public class Test055 {

    public static void main(String[] args) {
        String input = "A,5,B,10,A,8,A,17,B,17,B,1";
        String[] bidderName = new String[100];
        int[] bidValue = new int[100];

        String[] data = input.trim().split(",");
        int k = 0;
        for (int i = 0; i < data.length; i += 2) {
            bidderName[i/2] = data[i];
            bidValue[i/2] = Integer.parseInt(data[i + 1]);
            k++;
        }

        for (int i = 0; i < k; i++) {
            System.out.println(bidderName[i] + " // " + bidValue[i]);
        }
    }

}