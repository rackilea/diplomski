class Euler2 {
    public static void main(String args[]) {
        long n1=0,n2=1,n3,i,j;
        long sum = n1 + n2;
        for(i =2 ;i < 250; i++) {
            if (n3 > 40000000) {
                break;
            }
            else {
                n3 = n1 + n2;
                if (n3%2 == 0) {
                    sum += n3;
                }
                n1 = n2;
                n2 = n3;
            }
        }
        System.out.println("sum of all values: "+sum);
    }
}