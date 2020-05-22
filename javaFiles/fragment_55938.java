String line = inputStream.readLine();
   if (line.startsWith("/adduser")) {
      String[] arguments = line.split(" ");
      int id = 0;
      String password = "";

      for (int i = 0; i < arguments.length - 1; i++)
         if (arguments[i].equals("-id"))
            id = Integer.parseInt(arguments[i+1]);    // Assuming that your id values are integers.
         else if (arguments[i].equals("-p"))
            password = arguments[i+1];

      // Handle values
 }