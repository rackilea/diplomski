@XmlAccessorType(XmlAccessType.FIELD)
    public class Employee
    {
        @XmlAttribute
        @XmlID
        protected String id;

        @XmlAttribute
        protected String name;

        @XmlIDREF
        protected Employee manager;

        @XmlElement(name="report")
        @XmlIDREF
        protected List<Employee> reports;

        public Employee() {
            reports = new ArrayList<Employee>();
        }
    }