public static void factorial() {
int n;
int counter = 0;

for (n = num1; n <= num2; n++) {
    if ((n % 5 == 0 && n % 6 != 0) || (n % 6 == 0 && n % 5 != 0)) {
        System.out.print(n + " ");

        counter++;
        if (counter >= 9) {
            System.out.println();
            counter = 0;
        }

    }
}