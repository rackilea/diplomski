public interface Vehicle {

  static int getHorsePower(int rpm, int torque) {
        return (rpm * torque) / 5252;
    }
}   

Vehicle.getHorsePower(2500, 480));



public interface Cube {

      static double volume(double a){
          return a * a * a;
      }

      static double surface(double a){
         return 6*a*a;
      }
}