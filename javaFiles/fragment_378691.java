int[] array = {1, 2, 3, 4, 5};
int[] reversedArray = new int[array.length];

for (int i = 0; i < array.length; i++)
{
   reversedArray[i] = array[array.length - i - 1];
}

// print out contents of reversedArray to see that it works