public class AConverter implements CustomerConverter {
    protected final Logger LOG = LoggerFactory.getLogger(AConverter.class);

    private final static String SEPARATOR = ";";
    private final static String CR = "\n";

    public String create(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("no cust");

        LOG.info("Exporting customer, uidpk: {}, userid: {}",
                customer.getUidPk(), customer.getUserId());

        StringBuilder buf = new StringBuilder();
        doHead(buf, customer);
        doAddress(buf, customer);
        doTail(buf, customer);
        return buf.toString();
    }

    private void doHead(StringBuilder buf, Customer customer) {
        append(buf, "<HEAD>");
        append(buf, String.valueOf(customer.getUidPk()));
        append(buf, limitTo(40, customer.getFullName()));
    }

    private void doAddress(StringBuilder buf, Customer customer) {
        append(buf, limitTo(40, street1of(customer)));
        append(buf, limitTo(40, addressOf(customer)));
        append(buf, limitTo(80, customer.getEmail()));
        append(buf, limitTo(40, street2of(customer)));
        append(buf, limitTo(25, customer.getPhoneNumber()));
        append(buf, countryOf(customer));
        append(buf, countryOf(customer));
    }

    private void doTail(StringBuilder buf, Customer customer) {
        buf.append(fodselsnummerOf(customer));
        buf.append(CR);
    }

    private void append(StringBuilder buf, String s) {
        buf.append(s).append(SEPARATOR);
    }

    private String street1of(Customer customer) {
        final CustomerAddress shipto = customer.getPreferredShippingAddress();
        if (shipto == null) return " ";
        if (shipto.getStreet1() != null) return shipto.getStreet1();
        return " ";
    }

    private String street2of(Customer customer) {
        final CustomerAddress shipto = customer.getPreferredShippingAddress();
        if (shipto == null) return " ";
        if (shipto.getStreet2() != null) return shipto.getStreet2();
        return " ";
    }

    private String addressOf(Customer customer) {
        final CustomerAddress shipto = customer.getPreferredShippingAddress();
        if (shipto == null) return " ";

        final String post = preferredShippingAddress.getZipOrPostalCode();
        final String city = preferredShippingAddress.getCity();

        if (post != null && city != null) return post + " " + city;
        if (post == null && city != null) return city;
        if (post != null && city == null) return post;
        return " ";
    }

    private String countryOf(Customer customer) {
        final CustomerAddress shipto = customer.getPreferredShippingAddress();
        if (shipto == null) return " ";
        if (shipto.getCountry() != null) return shipto.getCountry();
        return " ";
    }

    private String limitTo(int numOfChars, String value) {
        if (value != null && value.length() > numOfChars)
            return value.substring(0, numOfChars);
        return value;
    }

    private String fodelsnummerOf(Customer customer) {
        try {
            Map<String, AttributeValue> profileValueMap =
                customer.getProfileValueMap();
            AttributeValue attributeValue = profileValueMap.get("CODE");
            return attributeValue.getStringValue();
        } catch (Exception e) {
            return " ";
        }
    }
}