@XmlRootElement(name="root")
public class SO {

    private List<Key<?>> keys;

    @XmlElementWrapper(name="Keys")
    @XmlElement(name="Key")
    public void setKeys(List<Key<?>> keys) {
        this.keys = keys;
    }

    public List<Key<?>> getKeys() {
        return keys;
    }

    @XmlType
    public static class Key<T> {

        private T val;

        @XmlValue
        @XmlJavaTypeAdapter(ToStringAdapter.class)
        public void setKey(T val) {
            this.val = val;
        }

        public String toString() {
            return "Key(" + val + ")";
        }

    }

    public static class ToStringAdapter extends XmlAdapter<String, Object> {

        @Override
        public Object unmarshal(String v) throws Exception {
            if(v.contains(".")) {
                return Double.parseDouble(v);
            } else {
                return Integer.parseInt(v);
            }
        }

        @Override
        public String marshal(Object v) throws Exception {
            return v.toString(); //Will never be called anyway so you could also throw an exception here
        }

    }

    private static final String XML_INT = "<root><Keys><Key>2</Key></Keys></root>";
    private static final String XML_DOUBLE = "<root><Keys><Key>2.7</Key></Keys></root>";

    public static void main(String [] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Key.class, SO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SO so = (SO) unmarshaller.unmarshal(new StringReader(XML_INT));
        System.out.print(so.keys);
        System.out.println(" " + so.keys.get(0).val.getClass().getSimpleName());
        so = (SO) unmarshaller.unmarshal(new StringReader(XML_DOUBLE));
        System.out.print(so.keys);
        System.out.println(" " + so.keys.get(0).val.getClass().getSimpleName());
    }

}