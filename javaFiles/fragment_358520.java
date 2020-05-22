public class Example {
    // sharedInstance
    private static Example sharedInstance = new Example();

    // to store/ pass events
    ArrayList<Events> eventsArrayList = new ArrayList<>();

    // private constructor
    private Example() {
    }

    // get sharedInstance
    public static Example getSharedInstance() {
        return sharedInstance;
    }

    public void addToEvents(Events events) {
        eventsArrayList.add(events);
    }
}