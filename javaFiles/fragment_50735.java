GaData results;
 if (null != results) {
     if(results.get("rows") != null){
          if (!results.getRows().isEmpty()){
               //do something with the rows exp.
               for (List<String> row : results.getRows()) {
                    for (int i=0; i<results.getColumnHeaders().size();i++) {
                        List<GaData.ColumnHeaders> headers = results.getColumnHeaders();
                        System.out.println( headers.get(i).getName()+": " + row.get(i));
                    }
                }
          }
     }
}