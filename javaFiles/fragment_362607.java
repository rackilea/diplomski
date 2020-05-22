if (arr == null || arr.length == 0) return 0;
int last = arr[0];
int max = 0;
int currNumDupes = 1;
for (int i = 1; i < arr.length; i++) { 
   if (arr[i] == last) currNumDupes++;
   else { 
        max = max > currNumDupes ? max : currNumDupes;
        currNumDupes = 1;
   }
   last = arr[i];
}
max = max > currNumDupes ? max : currNumDupes; //if the most dupes is from the highest element