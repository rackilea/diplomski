public static void main(String[] args) {
   int[] a = {1,2,3,4};
   int[] b = {5,6,7,8,9};
   int[] c = new int[Math.max(a.length,b.length)*2];

   for(int i=0; i<c.length; i++){
       if(i%2==0 && i/2 < a.length){
           c[i]=a[i/2];
       }
       if(i%2==1 && i/2 < b.length){
           c[i]=b[i/2];
       }           
   }
    System.out.println(Arrays.toString(c));
} 
//[1, 5, 2, 6, 3, 7, 4, 8, 0, 9]