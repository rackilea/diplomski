final int REMINDER = 4; //4 because you use %4
int curr = -1;
for (int r = 0; r < REMINDER ; r++) { 
   for (int i = curr + 1; i < arr.length; i++) { 
       if (arr[i] % REMINDER  == r) { 
          //swap elements:
          int temp = arr[i];;
          arr[i] = arr[++curr];
          arr[curr] = temp;
       }
   }
}