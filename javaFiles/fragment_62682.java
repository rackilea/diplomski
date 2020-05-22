public class Array {
 public static void main(String[] args) {
    System.out.println(" enter four digits between 0-100");
    Scanner cin = new Scanner(System.in);

    int n = 4;

    int[] num = new int[n];

    int i = 0;

    while(cin.hasNext() && i < n) {
        num[i] = cin.nextInt();
        i++;
    }

    int num1 = (new Array()).addNum(num, n);

    for(int j : num)
        System.out.println(j);



}

public int addNum(int[] num, int num1) {
    for (int i = 0; i < num1; i++) {
        num[i] += 5;
    }
    return num1;
}