int[] paths = new int[2dArray.length * 3];
int mapper = 0;

for (int i = 0; i < 2dArray.length; i++)
{
     paths[mapper] = 2dArray[i][0];
     paths[mapper + 1] = 2dArray[i][1];
     paths[mapper + 2] = 2dArray[i][2];
     mapper += 3;
}