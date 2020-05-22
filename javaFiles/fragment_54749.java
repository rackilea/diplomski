@SuppressWarnings("unchecked")
A<Integer>[] arr = new A[3];
B(){
   for(int i=0;i<arr.length;i++)
   arr[i]=new A<Integer>();
 }