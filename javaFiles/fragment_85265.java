public class CustomMySQL5InnoDBDialect extends MySQL5InnoDBDialect {

  public CustomMySQL5InnoDBDialect () {
    super();
    registerFunction( "datediff", new SQLFunctionTemplate( StandardBasicTypes.INTEGER, "datediff(?1, ?2)" ) );
 }

}