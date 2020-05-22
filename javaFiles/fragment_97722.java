X9ECParameters x9 = NISTNamedCurves.getByName("P-224"); // or whatever curve you want to use
ECPoint g = x9.getG();
BigInteger n = x9.getN();
int nBitLength = n.bitLength();
BigInteger x;
do
{
    x = new BigInteger(nBitLength, random);
}
while (x.equals(ZERO)  || (x.compareTo(n) >= 0));
ECPoint randomPoint = g.multiply(x);