int[] array = {1, 2, 3, 4, 5};

for (int i = 0; i < array.length/2; i++)
{
   int tmp = array[i];
   array[i] = array[array.length - i - 1];
   array[array.length - i - 1] = tmp;
}

// array is now reversed in place