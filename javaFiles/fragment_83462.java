@Listeners(ResultReporter.class)
public class CoreSingleApplicant1TestCase {

   @Test(dataprovider = "dataprovider",dataProviderClass = StaticProvider.class))
   public void runtest(String a, int b){
   }
}