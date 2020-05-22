FileOutputStream fouts = new 
        FileOutputStream("pathtofile");

    // Write object with ObjectOutputStream
    ObjectOutputStream outobj= new
        ObjectOutputStream (fouts);

    // Write object out to disk
    outobj.writeObject ( myWrapperInstance );