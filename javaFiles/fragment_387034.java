java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
    String computerName = localMachine.getHostName();    
        String searchString = "FindMe";
        while (itr.hasMoreTokens()) {
          String token = itr.nextToken();
          if (token.equals(searchString)) {
            word.set(token+" "+computerName);
            context.write(word, one);
          }
        }