package example;
import org.eclipse.persistence.oxm.NamespacePrefixMapper;

public class MyNamespacePrefixMapper extends NamespacePrefixMapper {

    private static final String BOO_PREFIX = ""; // DEFAULT NAMESPACE
    private static final String BOO_URI = "http://www.example.org/boo";
    private static final String FOO_PREFIX = ""; // DEFAULT NAMESPACE
    private static final String FOO_URI = "http://www.example.org/foo";
    private static final String HEADER_PREFIX = "h";
    private static final String HEADER_URI = "http://www.example.org/header";
    private static final String CUSTOMER_PREFIX = "c";
    private static final String CUSTOMER_URI = "http://www.example.org/customer";
    private static final String ADDRESS_PREFIX = "a";
    private static final String ADDRESS_URI = "http://www.example.org/address";

    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {

        switch (namespaceUri) {
            case BOO_URI:
                return BOO_PREFIX;
            case FOO_URI:
                return FOO_PREFIX;
            case HEADER_URI:
                return HEADER_PREFIX;
            case CUSTOMER_URI:
                return CUSTOMER_PREFIX;
            case ADDRESS_URI:
                return ADDRESS_PREFIX;
            default:
                return null;
        }
    }
}