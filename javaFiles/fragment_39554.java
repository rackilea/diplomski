public class MainActivity implements BLEConnectionListener {
    public void statusUpdated(String newStatus) {
        //do your thread thing here if you want to...
    }
}

public class GraphActivity implements BLEConnectionListener {
    public void statusUpdated(String newStatus) {
        //do graph stuff here
    }
}