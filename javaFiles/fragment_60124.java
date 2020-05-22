while ((line = bufferReader.readLine()) != null) 
 {  
      bufferdata+=  System.getProperty("line.separator") + line; 
      if(startSaving)
      {
           modifieddata += System.getProperty("line.separator") + line;
      }
      else  
      {
          originaldata += System.getProperty("line.separator") + line;
      }

      if(line.isEmpty())
      {
           startSaving = true; 
      }
  }

  if(modifieddata.isEmpty())
  {
      modifieddata = originaldata.trim();
  }
  else
  {
      modifieddata = modifieddata.trim();
  }

  String[] array = new String[]{modifieddata, originaldata};

  //Close the buffer reader
  bufferReader.close();

  // return array;