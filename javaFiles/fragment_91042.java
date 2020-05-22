public class ExampleInterceptor implements IMethodInterceptor {

@Override
public List<IMethodInstance> intercept(List<IMethodInstance> paramList, ITestContext paramITestContext) {

     //You have to watch out to get the right test if you have other tests in oyur suite        
    if (!paramITestContext.getName().equals("UnwantedTest")) {
        for (IMethodInstance iMethodInstance : paramList) {
            Object[] obj = iMethodInstance.getInstances();
            if (obj[0] instanceof Class1) {
                //DO your stuff like putting it in a list/array
            } else {
                //DO your stuff like putting it in a list/array with the other Testclasses
            }
        }
    }
    List<IMethodInstance> result = new ArrayList<IMethodInstance>();

            //Put the results in the results

    }
    return result;
}