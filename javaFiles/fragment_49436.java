public void update() {
    String r = "{\"rows\": [";
    List<TableRow> bqresults;
    if (!this.sql.isEmpty()){
        try {
            Bigquery bq = createAuthorizedClient();
            bqresults = executeQuery(bq, this.sql);
            int rowIx = 0;
            int rowMax = bqresults.size() - 1;
            for(TableRow row : bqresults) {
                r += row.toString();
                rowIx++;
                if (rowIx <= rowMax) r += ",";
            }
            r += "]}";
            this.results = r;  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}