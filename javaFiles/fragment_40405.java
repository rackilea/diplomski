public static void main(String[] args){
   int[][] arrayToBeFlattened = {{2,5,3,7,4,8},{3,4,1,2}};
   int[] oneD = flatten1(arrayToBeFlattened);

   for(int i=0; i<oneD.length;i++){
      System.out.print(oneD[i]+" ");
   }
}