public class XpathBuilder {

    private final StringBuilder sb;

    private static XpathBuilder instance;

    private XpathBuilder() {
        sb = new StringBuilder();
    }

    public static XpathBuilder newInstance() {
        if (instance == null) {
            instance = new XpathBuilder();
        }
        return instance;
    }

    public XpathBuilder child(String name) {
        sb.append("/").append(name);
        return this;
    }

    public XpathBuilder down(String name) {
        sb.append("//").append(name);
        return this;
    }

    public String build() {
        return sb.toString();
    }

}