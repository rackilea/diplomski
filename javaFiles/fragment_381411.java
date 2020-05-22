int n = arr_sort.length;
int i, j, temp; // min removed here
for (i = 0; i < n; i++)
{
  int min = i; // min declared here and changed to i
  for (j = i + 1; j < n; j++)
  {
     if (arr_sort[j] < arr_sort[min])
     {
        min = j;
     }
  }
  // moved swap to here
  temp = arr_sort[i];
  arr_sort[i] = arr_sort[min];
  arr_sort[min] = temp;
  System.out.print(arr_sort[i] + " ");
}