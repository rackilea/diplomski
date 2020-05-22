Scan bigtableScan = new Scan();
List<Result> getResults = null;
try(ResultScanner bigTableResults = bigtableTable.getScanner(bigtableScan)){
    getResults = new ArrayList<>();
    for(Result bigTableResult = bigTableResults.next(); (bigTableResult != null); 
       bigTableResult = bigTableResults.next()) {
         getResults.add(bigTableResult);
    }
}