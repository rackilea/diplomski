Random r = new SecureRandom();    
BigInteger q = something_big;
BigInteger ans;

do
    ans = BigInteger(bits_in_q, r);
while (ans.compareTo(q) >= 0); // bn_rand_range generates numbers < q