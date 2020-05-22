public class MyServerModule extends com.google.inject.AbstractModule {

 String appIdentifier = new File( System.getProperty("user.dir") ).getName();
 if ( appIdentifier.equals("trunk") ) {
  // Load MyConstants-dev.properties
  bind( MyConstants.class ).to( MyConstantsDev.class ).in(Singleton.class);
 } else {
  // Load MyConstants-prod.properties
  bind( MyConstants.class ).to( MyConstantsProd.class ).in(Singleton.class);
 }
}