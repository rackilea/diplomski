import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
class WILLITST_BigInteger {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BigInteger n=BigInteger.valueOf(Long.parseLong(br.readLine()));
        Set<BigInteger> s=new HashSet<BigInteger>();
        BigInteger x=BigInteger.valueOf(2);
        BigInteger y=BigInteger.valueOf(3);
        while(n.compareTo(BigInteger.ONE)==1){
            if(!s.add(n)){
                System.out.println("NIE");
                return;
            }
            if((n.and(n.subtract(BigInteger.ONE))).equals(BigInteger.ZERO)){
                System.out.println("TAK");
                return;
            }
            if((n.and(BigInteger.ONE)).equals(BigInteger.ZERO))
                n=n.divide(x);
            else n=y.multiply(n).add(y);
        }
        System.out.println("TAK");
    }
}