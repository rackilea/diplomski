while(true) {
    Socket pipe = socketConnection.accept();
    ObjectInputStream serverInputStream = new ObjectInputStream(pipe.getInputStream());

    ObjectOutputStream serverOutputStream = new ObjectOutputStream(pipe.getOutputStream());
    c =    (Calculator)serverInputStream.readObject(); //this is only done once
    while (true) { // you need logic to break out of this loop.
        c.setResult(s.Calculate(c.getFirstNumber(), c.getSecondNumber(), c.getOperation() ));
        serverOutputStream.writeObject(c); //this is done multiple times
    }