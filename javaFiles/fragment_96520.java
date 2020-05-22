public void readCsv(   ) throws IOException, URISyntaxException { // throws IOException  ---  String[] args
    System.out.println(".............");
    System.out.println(System.getProperty("user.dir"));

    val = 20; // testing purposes
    String [][] tab  = new String [100][400];
    int saveInThisRow = 0;

    File file = new File(getClass().getResource("/resources/GEMSTONES05.csv").toURI());
    //String csvFilename = "/resources/GEMSTONES05.csv";

    CSVReader csvReader = new CSVReader(new FileReader(file));
    String[] row = null;
    String total = "";
    while((row = csvReader.readNext()) != null) {

        for( int i = 0 ; i < 20 ; i++ ){  // no higher than num of columns to be found or error
            String saveAway = row[i];
            parent.println("CVS read  " + saveAway);
            //tabl[saveInThisRow][i] = row[i];
            tabl[saveInThisRow][i] = saveAway.replace('_', ' ');
        }
        saveInThisRow++;
        if(saveInThisRow == 20) { saveInThisRow = 0; break; }

    }

    csvReader.close();

    for( int i = 0 ; i < 300 ; i++){

    }

}