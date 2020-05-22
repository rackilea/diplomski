import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ans {
    public void display() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter number of weights");
        int n = Integer.parseInt(br.readLine()); // store the number of weights
        int Number[] = new int[n];
        int i, sum = 0, total = 0, j = 0;
        String m;
        System.out.println("enter the numbers");
        for (i = 0; i < n; i++) {
            m = br.readLine();
            Number[i] = Integer.parseInt(m); // store the inputed number in the array 

            if (Number[i] > 65) { // if the number > 65
                sum += Number[i];
                if ((i != 0) && ((j % 5) == 0) && (j != 0) && (i != (n - 2))) {
                    System.out.println("the sum is out " + sum);
                    total = total + sum;
                    sum = 0;
                    j = -1;
                } else if (i == (n - 2)) {
                    System.out.println("the sum is bad " + (sum * 1 / 6));
                    total += sum;
                }
                i++;
                ++j;
            } else if (Number[i] < 65) {
                sum = sum + Number[i];
                if (((i + 1) % 6) == 0) {
                    System.out.println("the sum is " + sum);
                    total = total + sum;
                    sum = 0;
                } else if (i == (n - 1)) {
                    System.out.println("the sum is bad " + sum);
                    total = total + sum;
                }

            }

        }
        System.out.println("the total of the sums is " + total);
    }

    public static void main(String[] args) throws IOException {
        Ans one = new Ans();
        one.display();
    }

}