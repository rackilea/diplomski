abstract class Vehicle{
    abstract void park();
}   

class Demo{
  static class Car extends Vehicle {
       int speed;
       void park(){
                System.out.println("Parking for cars...");
       }
   }

   public static void main(String args[]){
        Vehicle v1=new Car();
        v1.park();
   }
}