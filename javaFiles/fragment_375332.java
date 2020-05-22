// This interface defines the conversion method
interface Converter {
    Object fromString(String s);
}
// This map has one converter per supported class
static final Map<Class,Converter> mapper = new HashMap<Class,Converter>();
static {
    mapper.put(Integer.class, new Converter() {
        public Object fromString(String s) {
            return Integer.parseInt(s);
        }
    });
    mapper.put(Double.class, new Converter() {
        public Object fromString(String s) {
            return Double.parseDouble(s);
        }
    });
}