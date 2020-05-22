public class Vehicle
{
    // A unique ID
    private String id;
    // The destination
    private String destination;
    // The location of this taxi.
    private String location;

    /**
     *Constructor for vehicle
     */
    public Vehicle(String id)
    {
        this(id, null);
    }

    /**
     *Constructor for vehicle
     */
    public Vehicle(String id, String location)
    {
        this.id = id;
        this.location = location;
    }

    /**
     * Returns ID.
     * 
     */
    public String getID()
    {
        return id;
    }

    public String getDesitnation() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLocation() {
        this.location = location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

public class Taxi extends Vehicle   

    // Whether it is free or not.
    private boolean free;

    /**
     * Constructor for objects of class Taxi.
     * @param base The name of the company's base.
     * @param id This taxi's unique id.
     */


    public Taxi(String base, String id)
    {
        super(id, base);
        free = true;
    }
}

public class Shuttle extends Vehicle
{
    // The circular route of this shuttle.
    private ArrayList<String> route;
    // The destination number in route that the shuttle is
    // currently headed for.
    private int destinationNumber;

    /**
     * Constructor for objects of class Shuttle
     * @param id This shuttle's unique id.
     * @param route The route taken by this shuttle.
     *              The first entry is the starting location.
     */
    public Shuttle(String id, ArrayList<String> route)
    {
        super(id);
        this.route = route;
    }
}