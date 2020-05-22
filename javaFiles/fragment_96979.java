public class PrintPattern2 {
    public static void main(String[] args) {
        int i=0;
        int j=0;
        int k=0;
        int l=1;

        for(i=1;i<7;i++){
            System.out.println();
            if(i%2==0){
                k=l+i-1;
                for(j=1;j<=i;j++){
                    System.out.print(" "+k);
                    k=k-1;
                    l=l+1;
                }
            }else{
                k=l;
                for(j=1;j<=i;j++){
                    System.out.print(" "+k);
                    k=k+1;
                    l=l+1;
               }
            }
        }
        System.out.println();
    }
}