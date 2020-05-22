String line; 


try {            
BufferedReader br = new BufferedReader(new FileReader("<Location of text file>"));

     while((line=br.readLine()) != null){               
     helpText.append(line);
     //Add a new line for the next entry (If you would like)
     helpText.append("\n");
    } 
      //Set Cursor back to start
      helpText.setCaretPosition(WIDTH);
    }
   catch (IOException e) {             
   System.out.println (e);         
 }