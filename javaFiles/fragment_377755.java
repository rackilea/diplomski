int[][] array = new int[][] { { 1, 0 }, { 1, 0 }, { 1, 1 } };
int[] newArray = new int[6];
int index = 0;

// Populating 1D array.
for (int i = array[0].length; i > 0; i--)
    for (int j = 0; j < array.length; j++)
        newArray[index++] = array[j][i - 1];

// See the contents of 1D array.
for (int i = 0; i < newArray.length; i++)
    System.out.println(newArray[i]);