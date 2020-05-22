public class Main {
    public static void main(String[] args) {
        int x = 27;
        int[] y = {15, 20, 25, 30, 35, 40, 45};
        int[] result = new int[3];
        int z = 0;

        for(int i = 0; i < y.length; i++) {
            if(y[i] > x && z < 3) {
                result[z] = y[i];
                z++;
            }
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]); //Print 30 35 40
    }
}