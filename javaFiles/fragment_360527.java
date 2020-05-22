public class progprblm5{
     public static void main(String []args){
         double alpha[] = new double[50];
         for(int i =0;i<25;i++){
             alpha[i]= i*i;
         }
         for(int i = 25;i<50;i++){
             alpha[i]= 3*i;  // 3 times of index
         }
         System.out.println( "The values are: ");

         new progprblm5().print(alpha);  // method call
}
  void print(double array[]){
      for(int i=0; i < array.length; i++){ //iterate array from 0 index
            System.out.print(array[i]+ " , "); // print ith element
            if(i%10==0){
              System.out.println();
            }
      }
 }    
}