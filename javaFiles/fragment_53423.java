/**
 * The Qualifier interface TcpDriver. The value of this annotation is the name the implementation
 * is found under. Please only enter values that are configured in the wildfly config as the name of
 * the device.
 */
@Documented
@Qualifier
@Retention( RUNTIME )
@Target( { TYPE, FIELD, METHOD, PARAMETER } )
public @interface TcpDriver
{

  /**
   * Value.
   *
   * @return the string
   */
  String value();
}