public class OurLogger extends Action.Simple {
  private Result logResult(Result result) {
    System.err.println("Result body: "+
      JavaResultExtractor.getBody(result,1,null).utf8String());
  }
  public CompletionStage<Result> call(Context ctx) {
    return delegate.call(ctx)
      .thenApplyAsync(answer->logResult(answer));
  }
}