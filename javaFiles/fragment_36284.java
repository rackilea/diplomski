//------------- Pool Creation

ConnectionPool original = new ConnectionPool(String dbpoolName, ...); 
TrackingConnectionPool trackingCP = new TrackingConnectionPool(original);

// ... or without creating the ConnectionPool yourself
TrackingConnectionPool trackingCP = new TrackingConnectionPool(dbpoolName, ...);

// store the reference to the trackingCP instead of the original

//------------- TrackingConnectionPool

public class TrackingConnectionPool extends ConnectionPool {

    private ConnectionPool originalPool;  // reference to the original pool

    // Wrap all available ConnectionPool constructors like this
    public TrackingConnectionPool(String dbpoolName, ...) {
        originalPool = new ConnectionPool(dbpoolName, ...);
    }

    // ... or use this convenient constructor after you create a pool manually
    public TrackingConnectionPool(ConnectionPool pool) {
        this.originalPool = pool; 
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection con = originalPool.getConnection();
        return new TrackableConnection(con);   // wrap the connections with our own wrapper
    }
    @Override
    public Connection getConnection(long timeout) throws SQLException {
        Connection con = originalPool.getConnection(timeout);
        return new TrackableConnection(con);   // wrap the connections with our own wrapper
    }

    // for all the rest public methods of ConnectionPool and its parent just delegate to the original
    @Override
    public void setCaching(boolean b) {
        originalPool.setCaching(b);
    }
    ...
}

//------------- TrackableConnection

public class TrackableConnection implements Connection, Tracker.Trackable {

    private Connection originalConnection;
    private boolean released = false;

    public TrackableConnection(Connection con) {
        this.originalConnection = con;
        Tracker.resourceAquired(this);  // notify tracker that this resource is aquired
    }

    // Trackable interface

    @Override
    public boolean isReleased() {
        return this.released;
    }

    // Note: this method will be called by Tracker class (if needed). Do not invoke manually
    @Override
    public void release() {
        if (!released) {
            try {
                // attempt to close the connection
                originalConnection.close();
                this.released = true;  
            } catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Connection interface

    @Override
    public void close() throws SQLException {   
        originalConnection.close();
        this.released = true;   

        Tracker.resourceReleased(this); // notify tracker that this resource is "released"
    }

    // rest of the methods just delegate to the original connection

    @Override
    public Statement createStatement() throws SQLException {
        return originalConnection.createStatement();
    }
    ....
}

//------------- Tracker

public class Tracker {

    // Create a single object per thread
    private static final ThreadLocal<Tracker> _tracker = new ThreadLocal<Tracker>() {
            @Override 
            protected Tracker initialValue() {
                return new Tracker();
            };
    };

    public interface Trackable {
        boolean isReleased();
        void release();
    }

    // Stores all the resources that are used during the thread.
    // When a resource is used a call should be made to resourceAquired()
    // Similarly when we are done with the resource a call should be made to resourceReleased()
    private Map<Trackable, Trackable> monitoredResources = new HashMap<Trackable, Trackable>();

    // Call this at the start of each thread. It is important to clear the map
    // because you can't know if the server reuses this thread
    public static void start() {
        Tracker monitor = _tracker.get();
        monitor.monitoredResources.clear();
    }

    // Call this at the end of each thread. If all resources have been released
    // the map should be empty. If it isn't then someone, somewhere forgot to release the resource
    // A warning is issued and the resource is released.
    public static void stop() {
        Tracker monitor = _tracker.get();
        if ( !monitor.monitoredResources.isEmpty() ) {
            // there are resources that have not been released. Issue a warning and release each one of them
            for (Iterator<Trackable> it = monitor.monitoredResources.keySet().iterator(); it.hasNext();) {
                Trackable resource = it.next();

                if (!resource.isReleased()) {
                    System.out.println("WARNING: resource " + resource + " has not been released. Releasing it now.");
                    resource.release();
                } else {
                    System.out.println("Trackable " + resource 
                            + " is released but is still under monitoring. Perhaps you forgot to call resourceReleased()?");
                }
            }
            monitor.monitoredResources.clear();
        }
    }

    // Call this when a new resource is acquired i.e. you a get a connection from the pool
    public static void resourceAquired(Trackable resource) {
        Tracker monitor = _tracker.get();
        monitor.monitoredResources.put(resource, resource);
    }

    // Call this when the resource is released
    public static void resourceReleased(Trackable resource) {
        Tracker monitor = _tracker.get();
        monitor.monitoredResources.remove(resource);
    }
}