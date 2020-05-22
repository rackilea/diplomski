private BigInteger calculate_e(){
    Random r = new Random();
    BigInteger e;
    do{
        e = new BigInteger(phi.bitLength(), r);
    } while(!e.gcd(phi).equals(one));
    if(e.compareTo(phi)==-1 && e.compareTo(one)==1){
        return e;
    } else {
        return calculate_e();
    }
}