public static void main(String[] args) {
    int[][] coursesRemTak = new int[10][2];
    java.util.Scanner input = new Scanner(System.in);
    System.out.print("Enter classes remaining and taking each term for...\n");
    for (int i = 0; i < coursesRemTak.length; i++) {
        System.out.printf("Student %d: ", i + 1);
        for (int j = 0; j < coursesRemTak[i].length; j++) {
            coursesRemTak[i][j] = input.nextInt();
            if (coursesRemTak.length >= 0 && coursesRemTak[0].length <= 21) {
            }
        }
    }
    input.close();