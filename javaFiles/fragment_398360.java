private static final int FIRST_VALUE_COLUMN = 0;
private static final int HIGHEST_VALUE_COLUMN = 1;

...

        table[row][FIRST_VALUE_COLUMN] = getFirstValue(values);
        table[row][HIGHEST_VALUE_COLUMN] = getHighestValue(values);