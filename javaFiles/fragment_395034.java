public void run()
  {
      ...
      String threadName = Thread.currentThread().getName(); // --> added line
      // --> now append thread's name to logger name:
      Logger logger1=LoggerFactory.getLogger(" com.demo.wokerThread_" + threadName,"resources/log4j.xml");
      logger1.removeAllAppenders();
      ...
   }