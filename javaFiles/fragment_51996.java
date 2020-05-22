public static void main(String args []){
  Car car1 = new Car();
  car1.setSpeed(200);// should be setMaxSpeed();
  Car car2 = new Car();
  car2.setSpeed(250);

  System.out.println(car1.isFaster(car2));// prints false

}