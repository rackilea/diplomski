import java.io.IOException;
import java.io.InputStream;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;


public class ParkingExample {
    public static void main(String[] args) throws IOException {

        final String query = 
         "prefix d: <http://www.w3.org/2001/XMLSchema#>\n" +
         "prefix p: <http://parking.kmi.open.ac.uk/ontologies/parking#>\n" +
         "prefix s: <http://www.w3.org/2000/01/rdf-schema#>\n" +
         "prefix g: <http://www.w3.org/2003/01/geo/wgs84_pos#>\n" +
         "prefix o: <http://linkedgeodata.org/ontology/>\n" +
         "\n" +
         "select ?parking ?lat ?lon ?availability ?label where {\n" +
         "  ?parking a o:Parking ;\n" +
         "             g:lat ?lat ;\n" +
         "             g:long ?lon ;\n" +
         "             p:binaryAvailability ?availability .\n" +
         "  optional { ?parking s:label ?label }\n" +
         "}";

        Model model = ModelFactory.createDefaultModel();
        try ( final InputStream in = ParkingExample.class.getResourceAsStream( "/parking.ttl" ) ) {
            model.read( in, null, "TTL" );
        }

        final QueryExecution exec = QueryExecutionFactory.create( query, model );
        final ResultSet rs = exec.execSelect();
        while ( rs.hasNext() ) {
            final QuerySolution qs = rs.next();
            System.out.println( qs.get( "parking" ) +
                    "\n\t" + qs.get( "lat" ) +
                    "\n\t" + qs.get( "lon" ) +
                    "\n\t" + qs.get( "availability" ) +
                    "\n\t" + qs.get( "label" ));
        }
    }
}