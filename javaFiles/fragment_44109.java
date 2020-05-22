public class PathFinderWorker extends SwingWorker<Void, Path> {
    protected Void doInBackground() throws Exception {
        Input an ArrayList of 2 Dimensional Point objects.
        while(each point object has not been a starting point) 
        LOOP
            Arbitrarily choose a starting point
            Find the shortest path through all nodes
            publish(path);

        END LOOP
    }

    protected void process(List<Path> paths) {
        // Process the results as required...
    }
}