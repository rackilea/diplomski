public class primeNum {

    public static void main(String[] args) {
        int n=50;
        int notAPrime=0;

        System.out.println("All prime numbers before number " +n+ " are : ");
        for(int i=n; i>2; i--){
           for(int j=2; j<i; j++){
               if(i%j==0){
                  notAPrime++;
                  break; //your program is missing this statement
               }
            } 
            if(notAPrime==0){
               System.out.print(i + " ");                   
            }   
            notAPrime=0;     //In your program it is inside the if statement which makes it incorrect.
        }
    }
}