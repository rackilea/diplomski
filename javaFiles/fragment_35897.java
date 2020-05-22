for (int i = 1; i <= 2; i++){
  CSVReader reader = new CSVReader(new FileReader(args[i]));
  String [] nextLine;
  while ((nextLine = reader.readNext()) != null) {
         // nextLine[] is an array of values from the line
         //System.out.println(nextLine[0] + nextLine[1] + "etc...");

         for (String value:nextLine)
           System.out.print(value+" ");
         System.out.println();
  }
  reader.close();
}