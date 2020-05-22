ArrayList<Connection> connections;
public Accepter_clients(ArrayList<Connection> connections)
  {
      this.connections = connections;
  }

public void run()
{
    ServerSocket s; //initialize here
    while (true) //some boolean to continue instead
    {
        //...
        Connection newConn = new Connection(s.accept);
        synchronized (connections) { //cant modify list while using it elsewhere
            connections.add(newConn);
        }
    }
}