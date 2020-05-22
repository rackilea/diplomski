// 100 for rows and columns was chosen arbitrarily.
int[][] playedValues = new int[100][100];

int[] arrayOne = {1, 2, 3, 4, 5};
int[] arrayTwo = {1337, 9001, 1111111, 22222, 33333, 444, -1, -123, 246};

// Adding arrays to the list
playedValues[0] = arrayOne;
playedValues[1] = arrayTwo;

// Iterating through all arrays in playedValues
for(int i = 0; i < playedValues.length; i++) {
    for(int j = 0; j < playedValues[i].length; j++) {
        System.out.println(
            "Array #" + i + " - Element #" + j + " = " + currentArray[i][j]
        );
    }
}