public class While1000 {

    public static void main(String args[]) {

    int i, j, k, sum = 0;
    for (i = 1; i <= 1000; i++) {

        j = i;
        sum = i;

        while (sum < 1000)
        sum += ++j;

        if (sum == 1000) {
        for (k = i; k <= j; k++)
            System.out.print(k + " ");
        System.out.println();
        }
    }
    }
}

public class Dowhile1000 {

    public static void main(String args[]) {

    int i, j, k, sum = 0;
    for (i = 999; i <= 1000; i++) {

        j = i;
        sum = 0;

        do {
        sum += j++;
        } while (sum < 1000);

        if (sum == 1000) {
        for (k = i; k < j; k++)
            System.out.print(k + " ");
        System.out.println();
        }

    }
    }
}

public class For1000 {

    public static void main(String args[]) {

    int i, j, k, sum = 0;
    for (i = 1; i <= 1000; i++) {
        sum = 0;
        for (j = i; sum < 1000; ++j) {
        sum += j;
        }

        if (sum != 1000)
        continue;
        for (k = i; k < j; k++)
        System.out.print(k + " ");
        System.out.println();
    }
    }
}