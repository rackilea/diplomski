while(exists) 
        {
         String temp=dis.readLine();
         exists = (FilePath + "\\"+ temp).exists();
         if(!exists) {exportFile = new File(FilePath + "\\"+ temp); break;}

          }