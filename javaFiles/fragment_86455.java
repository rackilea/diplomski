public class Permutations {

   // testing
   public static void main(String[] args){        
    permutations(new int[]{1,2,3});    
   }

   public static void permutations(int[] array){
     boolean[] chosen = new boolean[array.length];
     int[] output = new int[array.length];
     permutation_inner(array,chosen,output,0);
   }
   public static void permutation_inner(int[] array, boolean[] chosen, 
                                        int[] output, int depth){
     if(depth==array.length){
       System.out.println(java.util.Arrays.toString(output));
       return;
     }
     for(int i=0;i<array.length;i++){
        if(!chosen[i]){
           chosen[i]=true;
           output[depth]=array[i];
           permutation_inner(array,chosen,output,depth+1);
           chosen[i]=false;
        }
     }
   }

}