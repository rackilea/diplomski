import groovy.xml.*
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

Document parseWithoutDTD( Reader r, boolean validating=false, boolean namespaceAware=true ) {
  FactorySupport.createDocumentBuilderFactory().with { f ->
    f.namespaceAware = namespaceAware
    f.validating = validating
    f.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    f.newDocumentBuilder().with { db ->
      db.parse( new InputSource( r ) )
    }
  }
}

Document d = new File( filename ).withReader { r ->
  parseWithoutDTD( r )
}