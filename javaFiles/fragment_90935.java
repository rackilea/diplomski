public class Country {
   private String countryName;
   private int number;

   public Country(String countryName, int number){
       this.countryName = countryName;
       this.number = number;
   }

   public String getCountryName(){
       return countryName;
   }

   public void setCountryName(String newCountryName){
       countryName = newCountryName;
   }

   public int getNumber(){
       return number;
   }

   public void setNumber(int newNumber){
       number = newNumber;
   }

   public String toString(){
       return getCountryName() + getNumber();
   }
}