public class Main {
static boolean isInitial = true;
static boolean isnChanged = true;
static Integer maxN = null;

static Integer matrix[][];
static List list = new ArrayList<Integer>();

public static void main(String[] args) throws ParseException {

    generateMatirx(3, 3);

    print2D(matrix);
}

public static Integer[][] generateMatirx(int m, int n) {

    if (isInitial) {
        matrix = new Integer[m][n];
        isInitial = false;
        --m;
        maxN = --n;
    }
    matrix[m][n] = checkAndAdd();
    if (n > 0) {
        isnChanged = true;
        --n;
    } else {
        isnChanged = false;
        if (maxN != 0)
            n = maxN;
    }
    if (!isnChanged && m > 0) {
        --m;
    }

    if (n == 0 && m == 0) {
        matrix[m][n] = checkAndAdd();
        return matrix;
    }

    return generateMatirx(m, n);
}

public static Integer checkAndAdd() {
    Integer integerRand = ThreadLocalRandom.current().nextInt(1, 3);
    if (list.contains(integerRand)) {
        return checkAndAdd();
    } else {
        list.add(integerRand);
        return integerRand;
    }
}

private static void print2D(Integer mat[][]) {
    // Loop through all rows
    for (Integer[] row : mat)
        // converting each row as string
        // and then printing in a separate line
        System.out.println(Arrays.toString(row));
}