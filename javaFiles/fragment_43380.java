System.out.println("Enter message. Blank line to quit.");
      mbody = menuScan.nextLine();

      while (!mbody.equals("")) {
           m.append(mbody);
           mbody = menuScan.nextLine();          
      }