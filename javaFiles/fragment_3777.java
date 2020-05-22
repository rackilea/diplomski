import java.io.IOException;
import java.io.InputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;


public class ParkingExample {
    public static void main(String[] args) throws IOException {
        // Read the model from whereever it comes from.  For this example, 
        // I made a local copy in parking.ttl and so I'm loading it as a 
        // resource.  You're already able to load the model, so this 
        // isn't so important.
        Model model = ModelFactory.createDefaultModel();
        try ( final InputStream in = ParkingExample.class.getResourceAsStream( "/parking.ttl" ) ) {
            model.read( in, null, "TTL" );
        }

        // Create some properties in advance for convenience.
        final Property g_lat = model.createProperty( "http://www.w3.org/2003/01/geo/wgs84_pos#lat" );
        final Property g_long = model.createProperty( "http://www.w3.org/2003/01/geo/wgs84_pos#long" );
        final Property p_binaryAvailability = model.createProperty( "http://parking.kmi.open.ac.uk/ontologies/parking#binaryAvailability" );

        // In N3, Turtle, and SPARQL, `a` is a shorthand for rdf:type.  That means
        // that each of the triples of the form 
        //
        //   <http://parking.kmi.open.ac.uk/data/parks/4934.1> a o:Parking
        //
        // is saying that the subject has rdf:type o:Parking.  That's how we'll retrieve
        // these resources.  We'll select subjects that have o_Parking as a value for 
        // rdf:type.  We'll predefine o_Parking for convenience.
        final Resource o_Parking = model.createResource( "http://linkedgeodata.org/ontology/Parking" );

        // Now we get an iterator over the resources that have type o_Parking.
        for ( final ResIterator res = model.listResourcesWithProperty( RDF.type, o_Parking ); res.hasNext(); ) {
            final Resource r = res.next();

            // For each one of them, it appears that they have a mandatory lat, lon, and binAvailability, 
            // so we can retrieve those values, assuming that they'll be there.
            final float lat = r.getRequiredProperty( g_lat ).getObject().asLiteral().getFloat();
            final float lon = r.getRequiredProperty( g_long ).getObject().asLiteral().getFloat();
            final boolean binAvailibility = r.getRequiredProperty( p_binaryAvailability ).getObject().asLiteral().getBoolean();

            // Some of the Parkings have an rdfs:label, but not all of them do.  For this, we'll retrieve
            // a statement, but since there might not be one, we have to check whether it's null.  If it 
            // is, then we'll make the label null, but otherwise we'll get the string value out of it.
            final Statement s = r.getProperty( RDFS.label );
            final String label = s == null ? null : s.getObject().asLiteral().getString();

            // Now you can do whatever you want with these values.  You could create an instance of another 
            // class, for instance.. I'll just print the values out.
            System.out.println( r + ":" +
                    "\n\tlatitude: " + lat +
                    "\n\tlongitude: " + lon +
                    "\n\tavailibility: " + binAvailibility +
                    "\n\tlabel: " + label );
        }
    }
}