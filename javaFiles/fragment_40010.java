public class OurLogger extends Action.Simple {

  @Inject Materializer materializer;

  private Result logResult(Result result) {
    System.err.println("Result body: "+
      JavaResultExtractor.getBody(result,1,materializer).utf8String());
  }

  // call() method unchanged
}