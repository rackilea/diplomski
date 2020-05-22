private static Vector<Countries> loadOB(String sFname) throws ClassNotFoundException, IOException {
        ObjectInputStream oStream = new ObjectInputStream(new FileInputStream(sFname));
        try{
          Object object = oStream.readObject();
          if (object instanceof Vector)
              return (Vector<Countries>) object;
          throw new IllegalArgumentException("not a Vector in "+sFname);
        }finally{
           oStream.close();
        }
     }