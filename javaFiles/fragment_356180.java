// File cm.Connection.java
package cm;

public class Connection {
    // The constructor has package access and so is available to 
    // ConnectionManager, but not to any class outside package cm
    Connection() { }
}

// File cm.ConnectionManager.java
package cm;

public class ConnectionManager {
    static private Connection[] _connections = new Connection[5];

    private ConnectionManager() {}

    static public Connection newConnectiton() {
        for ( int i = 0; i != _connections.length; ++i ) {
            if ( _connections[i] == null ) {
                _connections[i] = new Connection();
                return _connections[i];
            }
        }
        return null;
    }
}