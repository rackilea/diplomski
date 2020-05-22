ObjectInputStream serverInputStream = new ObjectInputStream(pipe.getInputStream());
    ObjectOutputStream serverOutputStream = new ObjectOutputStream(pipe.getOutputStream());
    while (true) { 
        c =    (Calculator)serverInputStream.readObject();
        c.setResult(s.Calculate(c.getFirstNumber(), c.getSecondNumber(),c.getOperation() ));
        serverOutputStream.writeObject(c);
    }