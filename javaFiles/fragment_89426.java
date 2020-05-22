Enumeration e = Logger.getRootLogger().getAllAppenders();
    while ( e.hasMoreElements() ){
      Appender app = (Appender)e.nextElement();
      if ( app instanceof FileAppender ){
        System.out.println("File: " + ((FileAppender)app).getFile());
      }
    }