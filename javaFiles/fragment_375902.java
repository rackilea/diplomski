package cars;

import java.util.ArrayList;
import java.util.List;

public class Showroom {

   private final List<Vehicle> theVehicles = new ArrayList<>();

   public boolean addVehicle( Vehicle newVehicle ) {
      theVehicles.add( newVehicle );
      return true;
   }

   public static void main( String[] args ) {
      final Showroom showroom = new Showroom();
      final Vehicle v1 = new Vehicle( "renault", "clio", "12", "290890" );
      showroom.addVehicle( v1 );
   }
}