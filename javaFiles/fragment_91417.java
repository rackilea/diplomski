public class Radian extends Number {

     private final double value;

     public Radian(double value){
          if (value < 0 || value >= 2 * PI)
               throw new IllegalArgumentException(value + " is out of range");
          this.value = value;
     }

     public double doubleValue(){
         return value;
     }

     // ... and other methods in the Number interface
     //   don't forget equals and hashCode and toString
}