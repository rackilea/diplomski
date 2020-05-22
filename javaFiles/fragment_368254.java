public class MyDomainClass {

 @Inject
 public MyDomainClass( Logger logger, MyConstants const ) { 
  logger.debug( const.myConstant() ); 
 };
}