public class App 
{
      public static void main( String[] args )
      {

           HolderConfig configHolderInstance = null;
           FileConfig file = null;
           configHolderInstance = HolderConfigBuilder.build(<Input Json>);
           file = configHolderInstance.getFile();
           System.out.println("The fileConfig is : "+file.toString());
      }
 }