private void reverse(int[] ar, int i, int j) {
   if(i>j)
     return;
   else{
     int temp = ar[i];
     ar[i] = ar[j];
     ar[j] = temp;
     reverse(ar, ++i, --j);
   }
}