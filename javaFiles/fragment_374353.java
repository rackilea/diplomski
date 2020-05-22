import org.w3c.dom.Document; 
import org.xml.sax.SAXException; 
import org.xml.sax.SAXParseException; 
import org.xml.sax.InputSource; 


import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.StringReader; 


import javax.xml.XMLConstants; 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import javax.xml.transform.Source; 

import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamSource; 
import javax.xml.validation.Schema; 
import javax.xml.validation.SchemaFactory; 
import javax.xml.validation.Validator; 

public class XmlSchemaValidationHelper { 

    public static void main(String[] argv) {
        XmlSchemaValidationHelper schemaValidationHelper = new XmlSchemaValidationHelper();
        schemaValidationHelper.validateAgainstSchema(new File(argv[0]), new File(argv[1]));
    }

    public void validateAgainstSchema(File xmlFile, File xsdFile) { 
        try {
            System.out.println("### Starting...");
            // parse an XML document into a DOM tree 
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance(); 
            builderFactory.setNamespaceAware(true); 
            DocumentBuilder parser = builderFactory.newDocumentBuilder(); 
            Document document = parser.parse(xmlFile); 

            // create a SchemaFactory capable of understanding WXS schemas 
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 

            // load a WXS schema, represented by a Schema instance 
            Source schemaFile = new StreamSource(xsdFile); 
            Schema schema = factory.newSchema(schemaFile); 

            // create a Validator instance, which can be used to validate an 
            // instance document 
            Validator validator = schema.newValidator(); 

            // validate the DOM tree 
            validator.validate(new DOMSource(document));
            System.out.println("### Finished...");

        } catch (FileNotFoundException ex) { 
            throw new OpenClinicaSystemException("File was not found", ex.getCause()); 
        } catch (IOException ioe) { 
            throw new OpenClinicaSystemException("IO Exception", ioe.getCause()); 
        } catch (SAXParseException spe) { 
            spe.printStackTrace(); 
            throw new OpenClinicaSystemException("Line : " + spe.getLineNumber() + " - " + spe.getMessage(), spe.getCause()); 
        } catch (SAXException e) { 
            throw new OpenClinicaSystemException(e.getMessage(), e.getCause()); 
        } catch (ParserConfigurationException pce) { 
            throw new OpenClinicaSystemException(pce.getMessage(), pce.getCause()); 
        } 
    } 

    public class OpenClinicaSystemException extends RuntimeException { 
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        private String errorCode; 
        private Object[] errorParams; 

        public OpenClinicaSystemException(String code, String message) { 
            this(message); 
            this.errorCode = code; 
        } 

        public OpenClinicaSystemException(String code, String message, Throwable cause) { 
            this(message, cause); 
            this.errorCode = code; 
        } 

        public OpenClinicaSystemException(String message, Throwable cause) { 
            super(message, cause); 
        } 

        public OpenClinicaSystemException(Throwable cause) { 
            super(cause); 
        } 

        public OpenClinicaSystemException(String message) { 
            super(message); 
            this.errorCode = message; 
        } 

        public OpenClinicaSystemException(String code, Object[] errorParams) { 
            this.errorCode = code; 
            this.errorParams = errorParams; 
        } 

        public OpenClinicaSystemException(String code, Object[] errorParams, String message) { 
            this(message); 
            this.errorCode = code; 
            this.errorParams = errorParams; 
        } 

        public String getErrorCode() { 
            return errorCode; 
        } 

        public Object[] getErrorParams() { 
            return errorParams; 
        } 

        public void setErrorParams(Object[] errorParams) { 
            this.errorParams = errorParams; 
        } 
    }

}