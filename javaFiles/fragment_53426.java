/** The callback Instance for the driver to find. */
  @Inject
  @Any
  private Instance<TcpConnection> callback;

  private TcpConnection driver;
  /**
  * Inject driver.
  */
  private void injectDriver()
  {
    final TcpDriver driver = new TcpDriverImpl( name );
    this.driver = callback.select( driver ).get();
  }