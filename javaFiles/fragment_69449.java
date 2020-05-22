Car car = new Car();
    ....

    //serialize an object called it car to a file called car.ser.
    try (
      OutputStream file = new FileOutputStream("car.ser");
      OutputStream buffer = new BufferedOutputStream(file);
      ObjectOutput output = new ObjectOutputStream(buffer);
    ){
      output.writeObject(car); // this call writes file to disk
    }  
    catch(IOException ex){
      logger.log(Level.SEVERE, "Cannot perform output.", ex);
    }