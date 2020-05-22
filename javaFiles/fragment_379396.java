public class Euler7 {
    public static void main(String[] args) {
        boolean prime;
        int cnt = 0;

        for(int count = 2; count <= 1000; count++){
            prime = true;
            for(int count1 = 2; count1 <= Math.sqrt(count); count1++) {
                if(count%count1==0) {
                    prime = false;
                    break;
                }
            }
            if(prime){
                cnt++;
                System.out.println(cnt + "th prime number is " + count);
            }
        }
    }
}