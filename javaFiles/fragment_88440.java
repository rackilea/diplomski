public static void Connect() throws InterruptedException { // It isn't nice to block forever, so we will allow for interrupt
    for (;;) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + host + ":" + port + "/"+ db;
            ct = DriverManager.getConnection(url, user, pass);
            st = ct.createStatement();
            System.out.println("Csatlakozva....\n");
            return; // Break out of loop because we got a connection - no exception was thrown
         }   ...

         // One of the exceptions happened. We will continue to loop so
         // we try to connect again until we are successful. We don't want
         // to retry too fast, because painful experience has taught us that
         // bad things can happen (full logs, 100% CPU, etc.).
         Thread.sleep(1);
    }
}