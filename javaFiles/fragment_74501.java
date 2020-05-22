class SomeClass {

  private Resource resource = null;

  public Resource getResource() {
    if (resource == null) {
      synchronized (this) {
        if (resource == null) 
          resource = new Resource();
      }
    }
    return resource;
  }
}