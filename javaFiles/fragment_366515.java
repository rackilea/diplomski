main(String[] zero) throws ClassNotFoundException{
    ArrayList<Connection> connections = new ArrayList<Connection>();
    //...
    Thread t = new Thread(new Accepter_clients(connections));
    t.start();

    //Server read/write loop
    boolean continue = true;
    while (continue)
    {
        synchronized(connections)
        {
            for (Connection c : connections)
            {
                //c.sendData();
            }

            for (Connection c : connections)
            {
                //c.readData();
            }
        }
    }
}