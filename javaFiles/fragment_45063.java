String[][] twoDimArray;
// something that sets up twoDimArray

for (String[] row : twoDimArray)
     replace (toSearchIn, row[0], row[1]);

// or, using an index:

for (int i = 0; i < twoDimArray.length; i++)
     replace (toSearchIn, twoDimArray[i][0], twoDimArray[i][1]);