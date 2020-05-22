public class ExceptionCleanser implements MethodRule {

      public Statement apply(final Statement base, FrameworkMethod method, Object target) {
          return new Statement() {
               public void evaluate() throws Throwable {
                 try {
                    base.evaluate();
                 } catch (Exception e) {
                       throw org.codehaus.groovy.runtime.StackTraceUtils.sanitize(e);     
                 }
               }
          };
      }
  }