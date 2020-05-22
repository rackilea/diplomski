void reset() {
  ILoggerFactory factory = LoggerFactory.getILoggerFactory();
  LoggerContext context = (LoggerContext)factory;
  context.reset();
  ContextInitializer initializer = new ContextInitializer(context);
  initializer.autoConfig();
}