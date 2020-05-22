public class PrintPattern1 {
    public static void main(String[] args) {
        int i=0;
        int j=0;
        int k=0;
        int l=4;

        for(i=1;i<6;i++){
            System.out.println();
            k=i;
            l=4;
            for(j=1;j<=i;j++){
                System.out.print(" "+k);
                k=k+l;
                l=l-1;
            }
        }
        System.out.println();
    }
}