String queryStr =
  "PREFIX spatial: <http://jena.apache.org/spatial#> " +
  "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
  "PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#> " +
  "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
  "PREFIX ssn: <http://purl.oclc.org/NET/ssnx/ssn#> " +
  "SELECT ?loc ?lat " +
  "WHERE {?loc spatial:nearby(35.5 32 1000 'km' ) . ?loc geo:lat ?lat}";

Model m = SemanticSensorModel.getIntance().getJenaModel();
EntityDefinition entDef = new EntityDefinition("1", "2");    
Dataset baseDataset = DatasetFactory.create(m);
try {
 Directory dir = FSDirectory.open( new File("/home/martin/spatial_index"));
 Dataset spatialDataset = SpatialDatasetFactory.createLucene(baseDataset, dir, entDef); 
   
 DatasetGraphSpatial dataset = (DatasetGraphSpatial) (spatialDataset.asDatasetGraph());
 SpatialIndex spatialIndex = dataset.getSpatialIndex();
 SpatialIndexContext context = new SpatialIndexContext(spatialIndex);
 spatialIndex.startIndexing();
    
 Iterator<Quad> quadIter = dataset.find(Node.ANY, Node.ANY, Node.ANY, Node.ANY);
 for (; quadIter.hasNext();) {
  Quad quad = quadIter.next();
  context.index(quad.getGraph(), quad.getSubject(), quad.getPredicate(), quad.getObject());
 }
 spatialIndex.finishIndexing();
       
 Query query = QueryFactory.create(queryStr) ;
 QueryExecution qexec = QueryExecutionFactory.create(query, spatialDataset);
 ResultSet results = qexec.execSelect() ;

 for ( ; results.hasNext() ; )
 {
  QuerySolution soln = results.nextSolution() ;
  System.out.println(soln.get("loc").toString() + " " + soln.get("lat").toString());
 }
    
 System.out.println("Done printing results");
} catch (IOException e) {
 e.printStackTrace();
}