@Singleton
public class ResultLoggerProvider {
   public ResultLogger get() {...}
   // ...
}

@Singleton
class ResultParser {
   private final ResultLoggerProvider loggerProvider;

   @Inject
   public ResultParser(ResultLoggerProvider loggerProvider) {
      this.loggerProvider = loggerProvider;
   }
}