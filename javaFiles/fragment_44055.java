//Init array
int array[][] = { { 5, 0, 0, 5, 0 }, { 4, 0, 0, 4, 7 },
                  { 9, 0, 4, 8, 9 }, { 0, 8, 4, 0, 1 } };

//Init vector for indices of elements with 0 value
ArrayList<int[]> indices = new ArrayList<int[]>();

//Find indices of element with 0 value
for (int i = 0; i < array.length; i++)
{
    for (int j = 0; j < array[i].length; j++)
    {
        if (array[i][j] == 0)
        {
            indices.add(new int[] { i, j });
        }
    }
}

//Just print the possible candidates
for (int[] index : indices)
{
   System.out.println("Index = (" + index[0] + ", " + index[1] + ")");
}
System.out.println();

//Select a random index and print the result
Random rand = new Random();
int ri = rand.nextInt(indices.size());
int[] index = indices.get(ri);

System.out.println("Selected index = (" + index[0] + ", " + index[1] + ")");