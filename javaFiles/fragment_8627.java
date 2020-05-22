public class PerfectNumbers
{
   static BigInteger[] genAllPerfect(int howMany)
   {
      if (howMany > 51)
         howMany = 51;

      int[] expn = { 2, 3, 5, 7, 13, 17, 19, 31, 61, 89, 107, 127, 521, 607, 1279, 2203, 2281, 3217, 4253, 4423, 9689,
            9941, 11213, 19937, 21701, 23209, 44497, 86243, 110503, 132049, 216091, 756839, 859433, 1257787, 1398269,
            2976221, 3021377, 6972593, 13466917, 20996011, 24036583, 25964951, 30402457, 32582657, 37156667, 42643801,
            43112609, 57885161, 74207281, 77232917, 82589933 };

      BigInteger Zero = BigInteger.ZERO;
      BigInteger[] perfectNums = new BigInteger[howMany];

      for (int i = 0; i < howMany; i++)
      {
         BigInteger perfect1 = Zero.setBit(expn[i] - 1); // 2^(p-1)

         perfectNums[i] = Zero.setBit(2 * expn[i] - 1); // 2^(2*p-1)

         perfectNums[i] = perfectNums[i].subtract(perfect1); // 2^(2*p-1) - 2^(p-1)
      }
      return perfectNums;
   }