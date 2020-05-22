ArrayList<ArrayList<class2>> obj = null;
    try {
         FastByteArrayOutputStream fbos = 
                new FastByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(fbos);
        out.writeObject(foo);
        out.flush();
        out.close();
        ObjectInputStream in = 
            new ObjectInputStream(fbos.getInputStream());
        obj = (ArrayList<ArrayList<class2>>) in.readObject();
    }
    catch(IOException e) {
        e.printStackTrace();
    }
    catch(ClassNotFoundException cnfe) {
        cnfe.printStackTrace();
    }
    return obj;