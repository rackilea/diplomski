public int[] rotateArray(int[] a) {    
         int n = a.length;
         int[] intArray=new int[n];

         for(int i=n;i>0;i--){
                intArray[n-i] = a[i-1];
         }
         return intArray;
}