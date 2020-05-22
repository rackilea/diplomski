public class NewClass {
    public static void main(String[] arg) {
        int[][] data = { { 1, 2 }, { 2, 2 }, { 1, 2, 4, 5 }, { 2, 2, 4, },
                { 1, 1, 4, 5 }, { 2, 1, } };

        int maxColLength = 0;
        for (int row = 0; row < data.length; row++) {
            int colLength = data[row].length;
            if (colLength > maxColLength) {
                maxColLength = colLength;
            }
        }

        for (int col = 0; col < maxColLength; col++) {
            int sum = 0;
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length) {
                    sum = sum + data[row][col];
                }
            }
            System.out.print("Sum of Column " + col + " is :  ");
            System.out.println(sum);
        }
    }
}