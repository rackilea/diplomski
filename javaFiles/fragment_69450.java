try(
      InputStream file = new FileInputStream("car.ser");
      InputStream buffer = new BufferedInputStream(file);
      ObjectInput input = new ObjectInputStream (buffer);
    ){
      //deserialize the List
      Car car = (Car)input.readObject();
      //display its data
      System.out.println("Recovered Car: " + car);

    }
    catch(ClassNotFoundException ex){
      logger.log(Level.SEVERE, "Cannot perform input. Class not found.", ex);
    }
    catch(IOException ex){
      logger.log(Level.SEVERE, "Cannot perform input.", ex);
    }