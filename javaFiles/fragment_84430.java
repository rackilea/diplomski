for (int row = 0; row < arrayheight; row++) 
    {
          if(!mazein.hasNextLine())
                break;            // if there is no more lines to read, break the loop 
          String line = mazein.nextLine();
          Char[] chars = line.toCharArray();

          for (int col = 0, i = 0; (col < arraywidth && i < chars.length); col++,i++) 
          {
            mazeAsArray[row][col] = chars[i];
            System.out.print(mazeAsArray[row][col]);
          }
    }