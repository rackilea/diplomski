private static BigInteger recSum (BigInteger val, BigInteger moddiv, BigInteger result)
{
    if (moddiv.compareTo(val) != 1){
        val = val.mod(moddiv);
        moddiv = moddiv.multiply(BigInteger.valueOf(10));
        result = result.add(recSum(val, moddiv, result));
    }

    return result;
}