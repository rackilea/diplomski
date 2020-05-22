for (Row row : rows){
    /*Get the list of rows for current client name.*/
    List<Row> currRows = map.get(row.clientName); 
    if (currRows == null) {/*If not list exists for*/
        currRows = new ArrayList<Row>(); /*create a new one*/
        map.put(row.clientName, currRows); /*and put it in the map*/
    }
    currRows.add(row);/*add the current row to the list*/
}