ResultSet results = preparedquery.executeQuery();

if (!results.next() ) {
System.out.println("no data");
}else{
results.last();
int rowCount = results.getRow();
}