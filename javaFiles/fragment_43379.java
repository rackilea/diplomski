System.out.println("Enter message. Blank line to quit.");
      mbody = menuScan.nextLine();

      while (!mbody.equals("")) {
           mbody = menuScan.next();
           m.append(mbody);
      }