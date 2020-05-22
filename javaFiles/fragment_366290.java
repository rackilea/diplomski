public static int Second_Tiny() {

  int[] ar = {19, 1, 17, 17, -2};

  //1st pass - find the smallest item on original array  
  int i;
  int z = ar[0];
  for (i = 1; i < ar.length; i++) {
    if (z >ar[i]){
      z=ar[i];
    }
  }

  //2nd pass copy all items except smallest one to 2nd array
  int[] ar2 = new int[ar.length-1];
  int curIndex = 0;
  for (i=0; i<ar.length; i++) {
    if (ar[i]==z)
      continue;
    ar2[curIndex++] = ar[i];
  }

  //3rd pass - find the smallest item again
  z = ar2[0];
  for (i = 1; i < ar2.length; i++) {
    if (z >ar2[i]){
      z=ar2[i];
    }
  }

  return z;
}