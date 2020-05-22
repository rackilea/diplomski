public class Main {
      public static void main(String[] args) {
         int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
         System.out.println("1.e odd index numbers in array : " +  Arrays.toString(oddIndex(arr)));

    }



     public static int[] oddIndex(int[] array){

         int[] newArr = new int[array.length];
         int j=0;
         for (int i = 0; i < array.length; i++){
             if ((i % 2) != 0) {
                 newArr[j++] = array[i];

             }
         }
         return Arrays.copyOf(newArr, j);
    }
 }