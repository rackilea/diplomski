while (input.hasNextLine()) {
     String line = input.nextLine();

     // get rid of white space followed by "//" followed by anything
     line = line.replaceAll("\\s+//.*", "");
     System.out.println(line);
  }