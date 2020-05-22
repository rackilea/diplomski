public class CompositeAutoCloseable implements AutoCloseable {

  private List<Closeable> resources;

  public CompositeAutoCloseable(Closeable... resources) {
    this.resources = Arrays.asList(resources);
    //you could use a stream here too
  }

  @Override
  public void close() {
      this.resources.stream().forEach(this::closeQuietly);
  }

  void closeQuietly(Closeable res) {
    if(res == null)  {
        return;
    }
    try {
        res.close();
    }catch(Exception e){
        //omit
    }
  } 
}