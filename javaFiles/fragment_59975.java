@XmlRootElement(name = "main")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class MainClass {
        @XmlElement(name = "mainPropA")
        private String title;
        @XmlElement(name = "mainPropB")
        private String author;
        private Elements elements;

        @XmlAccessorType(XmlAccessType.FIELD)
        static class Elements {
            List<String> propA;
            List<String> propB;
        }
    }
}