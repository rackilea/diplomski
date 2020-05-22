import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.sparql.engine.http.QueryExceptionHTTP;

public class QueryTest {

public static void main(String[] args) {
    String service = "http://your.virtuososerver.org/sparql";
    String query = "SELECT * WHERE {?s ?p ?o}";
    QueryExecution qe = QueryExecutionFactory.sparqlService(service, query);
    try {
       ResultSet results = qe.execSelect() ;
       for ( ; results.hasNext() ; ) {
           QuerySolution soln = results.nextSolution() ;
           RDFNode x = soln.get("s") ;
           RDFNode r = soln.get("p") ; 
           RDFNode l = soln.get("o") ;   
       }
    } catch (Exception e) {
        System.out.println("Query error:"+e);
    } finally {
        qe.close();
    }
 }