@TcpDriver( "terminal1" )
@Dependent
public class TestDriverImpl implements TcpConnection
{

  /** The log. */
  private Log log;

  @Inject
  public void init( Log log )
  {
    this.log = log;
  }

  @Override
  public void connected() throws NGException
  {
    // TODO Auto-generated method stub
    log.info( "IT WORKS!!" );
  }

  @Override
  public void received( byte[] data ) throws NGException
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void send( String data ) throws NGException
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void send( byte[] data ) throws NGException
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void closed() throws NGException
  {
    // TODO Auto-generated method stub
    log.info( "BYE BYE" );
  }