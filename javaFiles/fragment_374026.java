public class PatternRecognition {

private  double[] pattern = new double[161];
private double[] temp = new double[161];
private  int[] sums;
private static final int threshold = 2107270;

public int[] rec(int[] array) {
    sums = new int[array.length];
    int[] solution = array;
    int sum = 0;
    for (int x = 0; x < 161; x++) {
        temp[x] = Math.pow((array[x] - pattern[x]), 2);
        solution[x] = 0;
        sums[x] = sumArray(temp);
    }
        for (int x = 0; x < array.length-temp.length; x++) {
    for (int x2 =0; x2<temp.length ; x2++)
        temp[x2] = Math.pow((array[x+x2] - pattern[x2]), 2);
            sum = sumArray(temp);
            if (sum > threshold)
                solution[x] = 1;
            else solution[x] = 0;
            sums[x] = sum;
        }
    return solution;
}

private int sumArray(double[] temp) {
    int sum = 0;
    for (int x = 0; x < temp.length; x++) {
        sum += temp[x];
    }
    return sum;
}

private void cycleArray() {
    for (int x = (temp.length - 1); x > 0; x--) {
        temp[x] = temp[x - 1];
    }
}

public static void main(String[] args0) {
int[] data = new int[50000];
int x = 0;
while (x<data.length) {
    data[x] = x/2;
    x++;
}
PatternRecognition p=new PatternRecognition();
x=0;
while (x<p.pattern.length) {
    p.pattern[x] = x+1;
    x++;
}
int[] solutions = p.rec(data);
for (int y = 0; y < solutions.length; y++) {
    System.out.printf("%d: %d, Running Sum: %d %d\n", y + 1, solutions[y], p.sums[y], Integer.MAX_VALUE);
    System.out.println(solutions[y]);
}
}

}