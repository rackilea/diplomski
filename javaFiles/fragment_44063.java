public static String getContents(File aFile) {
    StringBuffer contents = new StringBuffer();
    BufferedReader input = null;
    try {
         InputStreamReader fr=new InputStreamReader(new FileInputStream(aFile), "UTF8");
        input = new BufferedReader( fr );
      String line = null; 
      while (( line = input.readLine()) != null){
        contents.append(line);
        contents.append(System.getProperty("line.separator"));
      }
    }
    catch (FileNotFoundException ex) {
      //ex.printStackTrace();
    }
    catch (IOException ex){
      //ex.printStackTrace();
    }
    finally {
      try {
        if (input!= null) {
          input.close();
        }
      }
      catch (IOException ex) {
        //ex.printStackTrace();
      }
    }
    return contents.toString();
  }