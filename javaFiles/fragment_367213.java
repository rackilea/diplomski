public class CircleClass{
   double radius; // class variable

   public CircleClass(double radius){
      this.radius = radius; // this.radius -> refers to the class variable
   }
   public void setRadius(double radius){
      this.radius = radius; // radius -> refers to the variable passed as argument
   }
}