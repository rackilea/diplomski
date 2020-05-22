FileReader reader1 = FileReader("file1.text")
    FileReader reader2 = FileReader("file2.text")

    while(reader1.hasNextLine() || reader2.hasNextLine()) 
    {
         if(reader1.hasNextLine()) {
         writeToCSV(reader1.nextLine());
         } 
         if(reader2.hasNextLine() {
         writeToCSV(reader2.nextLine());
         }
         writeToCSV("\r\n");
    }