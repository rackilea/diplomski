String line;

    try {

        BufferedReader bufferreader = new BufferedReader(new FileReader("C:\\Users\\ahmad\\Desktop\\aaa.TXT"));


        while ((line = bufferreader.readLine()) != null) {     
          /** 
            Your implementation  
          **/

        }

    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }