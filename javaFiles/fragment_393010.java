ConsoleAppender console = new ConsoleAppender(); //create appender
  //configure the appender
  String PATTERN = "%d [%p|%c|%C{1}] %m%n";
  console.setLayout(new PatternLayout(PATTERN)); 
  console.setThreshold(Level.FATAL);
  console.activateOptions();
  //add appender to any Logger (here is root)
  Logger.getRootLogger().addAppender(console);

  FileAppender fa = new FileAppender();
  fa.setName("FileLogger");
  fa.setFile("mylog.log");
  fa.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
  fa.setThreshold(Level.DEBUG);
  fa.setAppend(true);
  fa.activateOptions();

  /add appender to any Logger (here is root)
  Logger.getRootLogger().addAppender(fa)
  //repeat with all other desired appenders