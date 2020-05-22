import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Airport {
    public final int id;
    public String name;
    public List<Route> outboundRoutes = new ArrayList<Route>();
    public List<Route> inboundRoutes = new ArrayList<Route>();

    public double minDistance;
    public Airport previous;

    public Airport(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static class Route {
        public final int id;
        public double cost;
        public Airport departure;
        public Airport destination;

        public Route(int id, double cost, Airport departure, Airport destination){
            this.id = id;
            this.cost = cost;
            this.departure = departure;
            this.destination = destination;
        }
    }


    public static Map<Integer,Airport> readAirports(Scanner input){
        Map<Integer,Airport> airports = new HashMap<Integer,Airport>();
        while(input.hasNext()){
            //  Using a map rather than a list simplifies the process of loading 
            //  your routes, and eliminates problems that would crop up if some
            //  airports are listed out of order or removed.
            Airport port = new Airport(input.nextInt(), input.next());
            airports.put(port.id, port);
        }
        return airports;
    }


    //  Note that the list of airports must be passed when loading the routes, 
    //  but that nothing is returned -- the routes are loaded directly 
    //  into the airports.
    public static void readRoutes(Scanner input, Map<Integer,Airport> airports){

        while(input.hasNext()){
            int id = input.nextInt();
            int departureId = input.nextInt();
            int destinationId = input.nextInt();
            double cost = input.nextDouble();

            if(!(airports.containsKey(departureId) && 
                    airports.containsKey(destinationId))){
                //  You'll have to decide how to handle a situation when a route 
                //  refers to airports that don't exist
                throw new RuntimeException(
                        "Undefined airport referenced in route #" + id);
            }

            Route route = new Route(id, cost, airports.get(departureId), 
                    airports.get(destinationId));
            route.departure.outboundRoutes.add(route);
            route.destination.inboundRoutes.add(route);
        }
    }

    public static Map<Integer,Airport> loadAirports() throws FileNotFoundException {
        Scanner inAirports = new Scanner(new File("airports.txt"));
        Scanner inRoutes = new Scanner(new File("routes.txt"));
        Map<Integer,Airport> airports = readAirports(inAirports);
        readRoutes(inRoutes, airports);
        return airports;
    }

    public static void main(String[] args){
        try {
            Map<Integer,Airport> airports = loadAirports();
            for(Airport port : airports.values()){
                System.out.println(port.name + " has " + port.inboundRoutes.size() + " inbound routes and " + port.outboundRoutes.size() + " outbound routes ");
                for(Route r : port.inboundRoutes){
                    System.out.println("\tin from " + r.departure.name + " at a cost of $" + r.cost);
                }
                for(Route r : port.outboundRoutes){
                    System.out.println("\tout to " + r.destination.name + " at a cost of $" + r.cost);
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}