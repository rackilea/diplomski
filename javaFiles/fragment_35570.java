public class MyStoryReporter extends org.jbehave.core.reporters.NullStoryReporter{
  @Override
     public void successful(String step) {
        log.info(">>successStep:" + step);
     }
}