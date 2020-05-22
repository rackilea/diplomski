public class TripGuesser {
     private ArrayList<VehicleAbstract> vehicles;
     private DataAccessHandler dataAcces;
     private String stop_id;

     @SuppressWarnings("unchecked")
     public TripGuesser(ArrayList<VehicleAbstract> vehicles, DataAccessHandler dataAccess, String stop_id){
      this.vehicles = vehicles;
      this.dataAcces = dataAccess;
      this.stop_id = stop_id;
     }
 }


 public class HelsinkiStopsHandler {
      ...
      ArrayList<? extends VehicleAbstract> vehicles = vehiclesPerRoute.get(routeAndDirectionId);
      ArrayList<VehicleAbstract> vehiclesAbs = (ArrayList<VehicleAbstract>) vehicles;
      TripGuesser guesser = new TripGuesser(vehiclesAbs, dataAccess, last_stopId);
      ...
 }