File file = new File(filePath); 
    try { 
        // create FileWriter object with file as parameter 
        FileWriter outputfile = new FileWriter(file); 

        // create CSVWriter object filewriter object as parameter 
        CSVWriter writer = new CSVWriter(outputfile); 

        // adding header to csv 
        String[] header = { "id", "name", "design" }; 
        writer.writeNext(header); 

        // add data to csv 
       // in loop
        String[] data = {}
        writer.writeNext(data); 

       // execute this two line until your data remains. 

        // closing writer connection 
        writer.close(); 
    } 
    catch (IOException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
    }