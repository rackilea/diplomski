String[][] makeGrid = new String[][]{{"mysql", "dump", "grid", "se314"}, 
              {"mysql", "connect", "grid", ""},
              {"mysql",  "dump", "grid", ""},
              {"mysql", "connect", "rds", ""}
              };
     String[] query2 = new String[]{"my", "du", "gr"};

  String[][] matchingCommands = new String[4][4];
  int resultSize = 0;
     for(int i=0; i<makeGrid.length; i++)
  {
      String[] commandColumn = makeGrid[i];
   boolean matches = false;
      for(int cnt=0; cnt<commandColumn.length; cnt++)
      {
       String commandPart = commandColumn[cnt];
       if(cnt < query2.length){
        String queryPart = query2[cnt];
     if(commandPart.startsWith(queryPart) || queryPart.equals("?")){
         matches = true;
        }else{
         matches = false;
         break;
        }
       }
      }
      if(matches){
       matchingCommands[resultSize] = commandColumn;
       resultSize++;
      }
  }