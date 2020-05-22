public enum CarMaker {
   Honda,
   Toyota,
   Sony,
   Olympus,
   Facebook,
   Google,
   ...
}

public class Car {
   CarMaker carMaker;
   //... etc....

   Car(CarMaker carMaker) {
      this.carMaker = carMaker;
      // ... more code
   }

   //....