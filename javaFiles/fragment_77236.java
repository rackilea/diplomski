public class main1 {
    public static void main(String args[]) {

        int N = 5, n1, n2, n3;

        for (n1 = 0; n1 <= N; n1++) {
            for (n2 = 0; n2 <= N; n2++) {
                for (n3 = 0; n3 <= N; n3++) {
                    if ( (n1+n2+n3)==N ) {
                        System.out.println(n1 + " " + n2 + " " + n3);
                    }
                }
            }
        }
    }
}