void merge(int arr1[], int arr2[])
{
  int p1 = 0;
  int p2 = 0;
  int arr3[] = new int[arr1.length + arr2.length];

  while(p1 < arr1.length && p2 < arr2.length)
  {
    if(arr1[p1] > arr2[p2])
    {
      arr3[p2] = arr2[p2];
      p2++;
    }
    else
    {
      arr3[p1] = arr1[p1];
      p1++;
    }
  }

  //Now just add the code for just concatenating any remaining elements in 
  // either arr1 or arr2
  //This will happen if the lengths of arr1 and arr2 differ 


}