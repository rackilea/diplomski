$ javac Test.java # Contains all the above...
$ javap -c CarService

Compiled from "Test.java"
class CarService implements IService<Car> {
  CarService();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void create(Car);
    Code:
       0: return

  public void create(java.lang.Object);
    Code:
       0: aload_0
       1: aload_1
       2: checkcast     #2                  // class Car
       5: invokevirtual #3                  // Method create:(LCar;)V
       8: return
}