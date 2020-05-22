public class primeNum {

    public static void main(String[] args) {
        int n=50;
        int notAPrime=0;

        System.out.println("All prime numbers before number " +n+ " are : ");
        for(int i=n; i>2; i--){
           if(i%2==0){
               continue;
           }
           for(int j=3; j<i; j+=2){  
               if(i%j==0){
                  notAPrime++;
                  break;
               }
            } 
            if(notAPrime==0){
               System.out.print(i + " ");                   
            }   
            notAPrime=0;     
        }
    }
}