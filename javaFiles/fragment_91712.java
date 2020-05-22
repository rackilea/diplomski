final class YourTask implements Callable<YourResults> {

  private final YourInput input;

  YourTask(YourInput input) {
    this.input = input;
  }

  @Override
  public YourResults call() 
    throws Exception 
  {
    /* Do some number crunching and processing here. */
    return new YourResults(...);
  }

}