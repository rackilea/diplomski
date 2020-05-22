void java_example() {
  // open file (acquire resource)
  final LogFile logfile = new LogFile("logfile.txt");

  try {
      logfile.write("hello logfile!");

      // continue using logfile ...
      // throw exceptions or return without worrying about closing the log;
      // it is closed automatically when exiting this block
   } finally {
      // explicitly release the resource
      logfile.close();
   }
}