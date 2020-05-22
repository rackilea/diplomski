private static int nbInstances = 0;

    public Clasa () {
        nbInstances++;
    }

    public int getNo() {
        return nbInstances;
    }

  public void finalize(){
      nbInstances --;
      System.out.println("Number of Instantiate Object {After Calling GC}: "+nbInstances );
  }