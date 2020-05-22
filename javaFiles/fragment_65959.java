import java.math.BigInteger;
public static BigInteger power(int a,int b){
BigInteger b1 = new BigInteger(Integer.toString(a));  
BigInteger b2 = new BigInteger("1");
for(int i = 0; i < b; i++){
b2=b2.multiply(b1);
}
return b2;//return a^b
}