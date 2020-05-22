import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();
        char arr[][] = new char[5][5];
        char a[] = str.toCharArray();
        int l = a.length;
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (k != l) {
                    arr[i][j] = a[k];
                    k++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.print("Enter the string to search: ");
        String str1 = sc.next();
        char b[] = str1.toCharArray();
        int i, j, countH = 0, countV = 0;
        boolean found = false;
        for (i = 0; i < 5; i++) {
            countH = countV = 0;
            for (j = 0; j < 5 && countH < b.length && countV < b.length; j++) {
                if (arr[i][j] == b[countH]) {
                    countH++;
                } else if (arr[j][i] == b[countV]) {
                    countV++;
                }
            }
            if (countH == b.length) {
                found = true;
                System.out.println("Found horizontally starting at index " + "[" + (i) + "][" + (j - b.length) + "]");
            }
            if (countV == b.length) {
                found = true;
                System.out.println("Found vertically starting at index " + "[" + (j - b.length) + "][" + i + "]");
            }
        }
        if (!found) {
            System.out.println("Not Found");
        }
    }
}