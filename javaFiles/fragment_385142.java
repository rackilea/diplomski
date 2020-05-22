PrintWriter printer = null;
Scanner sc = null;
try
  {
     String lineSeparator = System.getProperty("line.separator");

     sc = new Scanner(new File(Input_filename));
     FileWriter fw = new FileWriter(Output_filename);
     printer = new PrintWriter(fw);

     while(sc.hasNextLine())
     {
        String s = sc.nextLine()+lineSeparator; //Add line separator
        printer.write(s);
     }
  }
  catch(IOException ioe)
  {
     System.out.println(ioe);
  } finally {
    if(sc != null) {
       sc.close();  
    }
    if(printer != null) {
      printer.flush();
      printer.close();
     }
 }