public static void main(String[] args) {
    int[] a = { 70, 70, 86, 53 };
    int number = 70;
    int done = occur(number, 0, a, 0);
    System.out.println(done);
}

public static int occur(int number, int count, int[] a, int index) {

    if (index == a.length) {
        return count;
    }

    else if (a[index] == number) {
        count += 1;
    }

    return occur(number, count, a, ++index);
}