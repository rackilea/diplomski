public class HeartbeatServer {
    private static HeartbeatServer heartbeatServer;

    // Disable object creation from other classes
    private HeartbeatServer () {
    }

    public static HeartbeatServer getInstance() {
          if(heartbeatServer == null)
              heartbeatServer = new HeartbeatServer();
          return heartbeatServer;        
    }
}