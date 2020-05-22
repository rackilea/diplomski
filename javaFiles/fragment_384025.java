import java.math.BigInteger;

public class P2Payment {
  BigInteger computePay(int DaysWorked) {
    BigInteger pay;
    if (DaysWorked == 1) {
      return new BigInteger("1");
    }

    else {
      DaysWorked = DaysWorked - 1;
      pay = computePay(DaysWorked).multiply(new BigInteger("2"));
      return pay;
    }
  }

  BigInteger computeSaving(BigInteger sum, int PDay, int NumofDays) {
    if (NumofDays == 1) {
      return new BigInteger("1");
    } else if (PDay <= NumofDays) {
      sum = sum.add(computePay(PDay));
      PDay++;
      BigInteger accumlateSum = computeSaving(sum, PDay, NumofDays);
      return accumlateSum;
    }
    return sum;

  }

}