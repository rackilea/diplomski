DateTimeFormatter formatter = new DateTimeFormatter(new DateTimePrinter()
  {
     // implements all abstract methods         
  }, null); // this instance has printer and hasn't parser
  formatter.print(new DateTime()); // works well
  formatter.parseDateTime("datetimestring"); // throws exeption