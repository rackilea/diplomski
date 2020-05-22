public class PhoneNumber  {
   private final String digits;
   private final String letters;
   public PhoneNumber(String digits, String letters)  {
      this.digits = digits;
      this.letters = letters;
   }
   public String getLetters()  {
      return  letters;
   }
   String getDigits()  {
      return  digits;
   }
}