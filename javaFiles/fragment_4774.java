int a = 69;
int sum = 0;

do {
    a /= 2;
    if (a % 2 == 0) {
        String output = (sum > 0) ? " + " : "";
        System.out.print(output + a);
        sum += a;
    }
} while (a > 1);

System.out.print(" = " + sum);