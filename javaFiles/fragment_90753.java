public static void main(String[] args) 
{

BigQuery bigquery = 
BigQueryOptions.getDefaultInstance().getService();


ExternalTableDefinition etd = 
ExternalTableDefinition.newBuilder("gs://", createSchema(), 
FormatOptions.csv()).build();

TableId tableId = TableId.of("testdataset", "mytablename");


bigquery.create(TableInfo.newBuilder(tableId, etd).build());


//Now query the table project.testdataset.mytablename

}