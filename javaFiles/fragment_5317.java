ArrayList<Integer[]> playedValues = ArrayList<Integer[]>();

int[] arrayOne = {1, 2, 3, 4, 5};

// Adding arrays to the list
playedValues.add(arrayOne);

// Iterating through all arrays in playedValues
for(int i = 0; i < playedValues.size(); i++) {
    int[] currentArray = playedValues.get(i);

    // Then, of course, you can loop over each array like normal:
    for(int j = 0; j < currentArray.length; j++) {
        System.out.println(
            "Array #" + i + " - Element #" + j + " = " + currentArray[i][j]
        );
    }
}