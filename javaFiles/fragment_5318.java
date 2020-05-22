ArrayList<ArrayList<Integer>> playedValues = ArrayList<ArrayList<Integer>>();

int[] arrayOne = {1, 2, 3, 4, 5};

// Adding values to the playedValues
playedValues.add( Arrays.asList(arrayOne) );

// Iterating through all values in playedValues
for(int i = 0; i < playedValues.size(); i++) {
    for(int j = 0; j < playedValues.get(i).size(); j++) {
        System.out.println(
            "Row #" + i + " - Column #" + j + " = " + playedValues.get(i).get(j)
        );
    }
}