/**
 * Pretty prints a given array of {@link Objects} in a grid. The resolution
 * of the grid depends on the amount of {@link Object}s passed along.
 * 
 * @param columns
 *            the number of columns present in the data.
 * @param spacing
 *            the number of spaces between each column.
 * @param objects
 *            the objects which need to be printed.
 * @throws NullPointerException
 *             when the given array of {@link Object}s is null.
 * @throws IllegalArgumentException
 *             when there are not enough objects to fill the given amount of
 *             columns. (i.e. objects.length must be divisible by columns).
 * @throws IllegalArgumentException
 *             when the amount of spacing is smaller than zero.
 */
public void prettyPrint(int columns, int spacing, Object... objects)
        throws NullPointerException, IllegalArgumentException {
    if (objects == null)
        throw new NullPointerException(
                "the given array of objects is null!");
    if (objects.length % columns != 0)
        throw new IllegalArgumentException(
                "not enough objects are passed along to fill the columns!");
    if (spacing < 0)
        throw new IllegalArgumentException(
                "the amount of spacing should be larger than zero!");
    int rows = objects.length / columns;

    // convert all objects to strings
    String[] strings = new String[objects.length];
    for (int i = 0; i < objects.length; ++i)
        strings[i] = objects[i].toString();

    // determine the maximum length of the items in each column
    int totalLength = 0;
    int[] maxLength = new int[columns];
    for (int column = 0; column < columns; ++column) {
        int maximum = 0;
        for (int row = 0; row < rows; ++row)
            maximum = Math.max(maximum,
                    strings[column + row * columns].length());
        maxLength[column] = maximum;
        totalLength += maximum;
    }

    // determine the total width of the output string (this is the sum of
    // maximum lengths of each column + the length caused by adding
    // (columns-1) spaces between the columns.
    totalLength += (columns - 1) * spacing;

    // print the header
    System.out.println(repeat("-", totalLength));

    for (int row = 0; row < rows; ++row) {
        for (int column = 0; column < columns; ++column) {
            // print the string
            String string = strings[column + row * columns];
            System.out.print(string);

            // print the spaces except after the element in the last column
            if (column < columns - 1) {
                int spaces = maxLength[column] - string.length() + spacing;
                System.out.print(repeat(" ", spaces));
            }
        }
        System.out.println();
    }
    // print the footer
    System.out.println(repeat("-", totalLength));
}

/**
 * Repeats the given {@link String} n times.
 * 
 * @param str
 *            the {@link String} to repeat.
 * @param n
 *            the repetition count.
 * @throws IllegalArgumentException
 *             when the given repetition count is smaller than zero.
 * @return the given {@link String} repeated n times.
 */
public static String repeat(String str, int n) {
    if (n < 0)
        throw new IllegalArgumentException(
                "the given repetition count is smaller than zero!");
    else if (n == 0)
        return "";
    else if (n == 1)
        return str;
    else if (n % 2 == 0) {
        String s = repeat(str, n / 2);
        return s.concat(s);
    } else
        return str.concat(repeat(str, n - 1));
}

/**
 * Repeats the given {@link String} n times.
 * 
 * @param str
 *            the {@link String} to repeat.
 * @param n
 *            the repetition count.
 * @throws IllegalArgumentException
 *             when the given repetition count is smaller than zero.
 * @return the given {@link String} repeated n times.
 */
public static String repeat(String str, int n) {
    if (n < 0)
        throw new IllegalArgumentException(
                "the given repetition count is smaller than zero!");
    else if (n == 0)
        return "";
    else if (n == 1)
        return str;
    else if (n % 2 == 0) {
        String s = repeat(str, n / 2);
        return s.concat(s);
    } else
        return str.concat(repeat(str, n - 1));
}