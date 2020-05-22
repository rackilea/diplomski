for (int i = 0; !TextIO.eof(); i++){
      int value = TextIO.getInt();
      int targetIndex = (i/5)*5;
      for (; targetIndex < putInList.size(); targetIndex++)
      {
          if(putInList.get(targetIndex)>value)
          {
            break;
          }
      }
      putInList.add(targetIndex,value);

    }