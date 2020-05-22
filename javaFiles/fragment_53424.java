/**
 * The Class TcpDriverImpl.
 */
public class TcpDriverImpl extends AnnotationLiteral<TcpDriver> implements TcpDriver
{

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The name. */
  private final String name;

  /**
   * Instantiates a new tcp driver impl.
   *
   * @param name the name
   */
  public TcpDriverImpl( final String name )
  {
    this.name = name;
  }

  /** {@inheritDoc} */
  @Override
  public String value()
  {
    return name;
  }

}