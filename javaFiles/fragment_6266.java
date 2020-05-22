class TalendDependencyModule extends AbstractModule {
  @Override public void configure() {
    requestStaticInjection(ExtractorDependencies.class);
    requestStaticInjection(ProcessorDependencies.class);
  }
}

public class ExtractorDependencies {
  @Inject private static Provider<ParserService> parserServiceProvider;
  @Inject private static Provider<SomethingElse> somethingElseProvider;

  private ExtractorDependencies() { }

  static ParserService getParserService() {
    return parserServiceProvider.get();
  }

  /* ... */
}