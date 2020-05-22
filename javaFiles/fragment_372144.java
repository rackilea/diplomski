public class IRITest {
public static void main(String[] args) {
    IRIFactory factory = IRIFactory.uriImplementation();
    IRI iri = factory.construct("http://blah.org/A_%28Secret%29.xml#blah");
    ArrayList<String> a = new ArrayList<String>();
    a.add(iri.getScheme());
    a.add(iri.getRawUserinfo());
    a.add(iri.getRawHost());
    a.add(iri.getRawPath());
    a.add(iri.getRawQuery());
    a.add(iri.getRawFragment());
    IRI iri2 = factory.construct("http://blah.org/A_(Secret).xml#blah");
    ArrayList<String> b = new ArrayList<String>();
    b.add(iri2.getScheme());
    b.add(iri2.getRawUserinfo());
    b.add(iri2.getRawHost());
    b.add(iri2.getRawPath());
    b.add(iri2.getRawQuery());
    b.add(iri2.getRawFragment());

    System.out.println(a);
    //[http, null, blah.org, /A_%28Secret%29.xml, null, blah]
    System.out.println(b);
    //[http, null, blah.org, /A_(Secret).xml, null, blah]
}
}