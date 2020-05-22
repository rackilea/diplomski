interface Fact {

}
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
class R {

    @XmlElement(name = "fact")
    private List<Object> facts;


    @SuppressWarnings("unchecked")
    public List<Fact> getTest() {
        if (facts == null) {
            facts = new ArrayList<>();
        }
        return (List<Fact>) (Object) facts;
    }

    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        // check if all facts implement same interface
        for(Object object:facts) {
            if (!(object instanceof Fact)) {
                throw new IllegalArgumentException("Unsupported type in facts list");
            }
        }
    }
}

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "aFact")
class AFact implements Fact {

    @XmlElement
    private String a;

    public AFact() {
    }

    public AFact(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    @Override
    public String toString() {
        return "AFact [a=" + a + "]";
    }

}

public class Jax {
    public static void main(String[] args) throws JAXBException {

        String xml = "<r><fact xsi:type=\"aFact\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><a>ba</a></fact></r>";

        List<Class<?>> contextClasses = new ArrayList<>();
        contextClasses.add(R.class);
        contextClasses.addAll(getClassesFromPlugin());
        JAXBContext context = JAXBContext.newInstance(contextClasses.toArray(new Class<?>[0]));
        R entity = (R) context.createUnmarshaller().unmarshal(new StringReader(xml));

        System.out.println(entity.getTest());

        R r = new R();
        r.getTest().add(new AFact("ab"));

        context.createMarshaller().marshal(r, System.out);
    }

    private static List<Class<?>> getClassesFromPlugin() {
        List<Class<?>> asList = Arrays.asList(AFact.class);
        for(Class<?> cls:asList) {
            if (!Fact.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Unsupported class");
            }
        }
        return asList;
    }
}