public class Test{

     public static void main(String[] args){

         Car c = new Car();
        checkCar(c);
        c = new Ferrari();
        checkCar(c);
        c = new Honda();
        checkCar(c);

     }




    public static void checkCar(Car c){

        c.start();
    }
  }

 class Car{

    public void start(){
        System.out.println("Car Starts");
    }

 };

 class Ferrari extends Car{
    public void start(){
        System.out.println("Ferrari Starts");
    }
 };

 class Honda extends Car{
    public void start(){
        System.out.println("Honda Starts");
    }
 };