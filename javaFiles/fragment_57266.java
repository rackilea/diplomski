Scanner fScn = new Scanner(new File(“items.txt”));
      String data;

      while( fScn.hasNextLine() ){
           data = fScn.nextLine();

           String[] token = data.split(" ");
           itemId = Integer.parseInt(token[0]);
           itemName= token[1];
           itemShelve = token[2];
           itemCode = token[3];
      }
      fScn.close();