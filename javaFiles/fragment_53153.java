//To define all the properties needed to make the rdf of the email

package email;
import com.hp.hpl.jena.rdf.model.*;


public class EMAILRDF {
    //Create a default model
    private static Model m = ModelFactory.createDefaultModel();

//Subject of the mail
public static final Property SUBJECT = m.createProperty("SUB:" );
//Sender of the mail
public static final Property FROM = m.createProperty("FROM:" );
//Receiver of the mail
public static final Property TO  = m.createProperty("TO:" );
//Return path
public static final Property RETURN_PATH = m.createProperty("RETURNPATH:" );
//main contents of the mail
public static final Property CONTENT = m.createProperty("CONTENT:" );
//format of the mail
public static final Property FORMAT = m.createProperty("FORMAT:" );
//content type like html etc
public static final Property CONTENT_TYPE = m.createProperty("CONTENTTYPE:" );
//encoding in bits
public static final Property ENCODING = m.createProperty("ENCODING:" );
//date of the email
public static final Property DATE = m.createProperty("DATE:" );