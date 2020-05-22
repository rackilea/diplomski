public class series { 
    public static void main (String args[]){ 

        int n=5; 
        if((n>=1 && n<=9)){ 
            for(int i=0;i<n;i++){ 
                //spacing logic 
                for(int s=0; s < i; s++){ 
                    System.out.print(" "); 
                } 
                //main logic: loop1 
                for(int j=n ; j > i; j--){
                    System.out.print(n-i); 
                } 
                System.out.println();
            } 

            for(int i=2;i<=n;i++){ 
                //spacing logic 
                for(int s=n;s>i;s--){
                    System.out.print(" ");
                } 
                //main logic: loop2 
                for(int j=1;j<=i;j++){
                    System.out.print(i); 
                }
                System.out.println(); 
            } 
        } else{
            System.out.println("Invalid Input"); 
        }
    }
}