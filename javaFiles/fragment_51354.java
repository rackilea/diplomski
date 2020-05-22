for (int row = 0; row < EntryList.length; row++)
  {
          for(int col = 0; col < EntryList[row].length;col++) {
               if(EntryList[row][col] != null)
                  outstream.writeUTF(EntryList[row][col]); 
          } 
  }