class OneDeptITItemReader implements ItemReader<Customer> {
  ItemReader<Customer> delegate;

  @Override
  public Customer read() {
    boolean read = true;
    while(read)  {
     Customer item = delegate.read();
     read = read != null && !"IT".equals(item.getDept());
    }
    return item;
  }
}