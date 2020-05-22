JasperReport report = (JasperReport) JRLoader.loadObject(inStream);

//this is the actual query in the report
JRQuery query = report.getMainDataSet().getQuery;

//once here you get the entire sql string, this will have any parameters replaced with 
//the '?' character
String queryString = query.getText();

//now start building your prepared statement, I am assuming you already have your
//connection in the conn variable
PrepararedStatment statement = con.prepareStatement(queryString);

//almost there, need to set the parameters
//the sql query is broke up into chunks inside the JRQuery. The chunks have types 
//that are  either text, parameter, or parameter clause. We care about parameter, 
//not sure what parameter clause would be to be honest
int index = 0; //this is the index to set the parameter at in the statement
for (JRQueryChunk chunk : query.getChunks()){
     if (chunk.getType() == JRQueryChunk .TYPE_PARAMETER){
         statement.setObject(index, params.get(chunk.getText()));
         index = index + 1;
     }
}
//then execute the query
ResultSet results = statement.executeQuery();