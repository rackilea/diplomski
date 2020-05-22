if (arr == null || arr.length == 0) return 0;
int last = arr[0];
int numDupes = 1;
for (int i = 1; i < arr.length; i++) { 
   if (arr[i] == last) numDupes++;
   last = arr[i];
}