int [] arr = new int[]{1,2,3,4,5};
int [] expected = new int[]{3,4,5,6,5,6,7,7,8,9};
int index = 0;
for(int i=0; i<arr.length - 1; i++){
  for(int j=i+1; j<arr.length; j++){
       int temp = arr[i] + arr[j];
       if(temp == expected[index++]){
             #logic
       }
   }
 }