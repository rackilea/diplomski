import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        int[][] num = new int[3][5];
        System.out.println("Before:");
        for (int i = 0; i < 3; ++i)
            System.out.println(Arrays.toString(num[i]));
        Set<Integer> data = new HashSet<Integer>();
        for (int i = 0; i < 3; i++) { // 3 rows with 5 numbers each
            for (int j = 0; j < 5; j++) {
                boolean isGoodInput = false;
                while (!isGoodInput) {
                    String input = JOptionPane.showInputDialog(null, "Enter value for line: " + i + " and position: " + j);
                    Integer n = Integer.parseInt(input);
                    if (data.contains(n)) {
                        JOptionPane.showMessageDialog(null, "ERROR: Try again");
                    } else {
                        num[i][j] = n;
                        isGoodInput = data.add(n);
                    }
                }
            }
        }
        System.out.println("After:");
        for (int i = 0; i < 3; ++i)
            System.out.println(Arrays.toString(num[i]));
    }
}