public static void readFileToMap() {

    String csvFile = inputDirPreFix + "input/file2.tsv";
    String []  strArrHeaderFields =new String [20]  ;
    HashMap objDataHashMap ;
    HashMap <Integer,Object> objAggregateData = new HashMap(); ;

    String [] strArrValues = new String[20];

    try {
        List<String> fileLinesList = Files.readAllLines(Paths.get(csvFile));

        strArrHeaderFields =fileLinesList.get(0).split(",");
        //System.out.println( Arrays.toString(objHeaderFields)  );

        //skip header line and collect data lines in hashmap with Name as Header line values..
        // for every data line,
        for( int i=1; i< fileLinesList.size(); i ++) {
            objDataHashMap = new HashMap();
            //get values from each data line
            strArrValues =fileLinesList.get(i).split(",");

            for( int j=0; j< strArrHeaderFields.length; j++) {
                 objDataHashMap.put(strArrHeaderFields[j], strArrValues[j]);
            }

            //System.out.println( "objDataHashMap Count of Records ...." + objDataHashMap.size() );
            objAggregateData.put(i,objDataHashMap);

        }
        System.out.println( "objAggregateData Count of Records ...." + objAggregateData.size() );

        objAggregateData.forEach((k,v) -> {
            System.out.println(k + " : " + v );
        });

    } catch (Exception ex) {
        Logger.getLogger("FileProcessing").log(Level.SEVERE, null, ex);
    }
}