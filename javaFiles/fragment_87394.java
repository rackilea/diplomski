public static void main(String[] args) {
    guess(2, 1, 4, new int[]{2, 4});
}

/**
 *
 * @param tries tries count
 * @param from from range, inclusive
 * @param to to range inclusive
 * @param puzzled array with puzzled values
 * @return array, which contains only puzzled answers from a user
 */
public static int[] guess(int tries, int from, int to, int[] puzzled) {
    if (puzzled == null || puzzled.length < 1) throw new IllegalArgumentException("puzzled");
    if (Math.abs(from - to) < 1) throw new IllegalArgumentException("range");
    if (tries < 1 || Math.abs(from - to) < tries - 1) throw new IllegalArgumentException("tries"); //`tries - 1` because `to` is inclusive
    if (from > to) {
        int tmp = from; from = to; to = tmp;
    }
    Scanner sc = new Scanner(System.in);
    int answers[] = new int[tries], //all previous user answers
        result[] = new int[tries];

    System.out.printf("You have only %d chances to get all\n", tries);
    int i = 0, j = 0;
    while (i < tries && j < puzzled.length) { // `j < puzzled.length` break if all puzzled answers is found
        System.out.printf("%d Enter number %d-%d: ", (i + 1), from, to);
        int number = sc.nextInt();
        if (number < from || number > to) {
            System.out.printf("Number must be in %d-%d range only, try again\n", from, to);
            continue;
        }
        if (contains(answers, number, i)) {
            System.out.printf("Number %d is used before\n", number);
            continue;
        }

        answers[i++] = number;
        if (contains(puzzled, number)) {
            System.out.println("Wow!! you got it");
            result[j++] = number;
        } else {
            System.out.println("Not here");
        }
    }
    if (j == puzzled.length)
        System.out.println("You got all");
    else
        System.out.printf("You got %d only\n", j);
    return Arrays.copyOfRange(result, 0, j);
}

private static boolean contains(int[] array, int value) {
    return contains(array, value, array.length);
}

private static boolean contains(int[] array, int value, int lookTo) {
    for (int i = 0; i < lookTo; i++)
        if (array[i] == value)
            return true;
    return false;
}