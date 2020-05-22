public class Bonus extends RealmObject {
   byte[] thebonus;

   @Ignore
   BigInteger bonus;

   public BigInteger getBonus() {
       if (bonus == null) {
           bonus = new BigInteger(thebonus);
       } 
       return bonus;
   }

   public void setBonus(BigInteger newBonus) {
       bonus = newBonus;
       thebonus = BigInteger.toByteArray();
   }
}