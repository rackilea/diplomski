private void send(Connection c, Data d) {
  synchronized (c) {
    // for each connection object, only one thread may be inside this block.
    // all other threads wait until the thread currently in this block exits it.
    c.send(d);
  }
}

// somewhere else ...

Data data = determineDataToSend()
Connection connection = map.get(key);
send(connection, data)