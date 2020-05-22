public class HeightConverter{  
   public static void main (String[] args) {
    Student myName = new Student ("Rachel");
    int myAge; //age in years
    myAge = 18;
    int myHeight; //height in inches
    myHeight = 66;
    double myHeightCM; //height in cm
    myHeightCM = (2.54 * myHeight);
    System.out.println(myName.getName());
    System.out.println(myAge);
    System.out.println(myHeight);
    System.out.println(myHeightCM);
   }
  }