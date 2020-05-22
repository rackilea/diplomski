public class JacksonInheritance {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Competence c = new Competence();
        c.desc = "desc";
        c.nome = "nome";
        c.template = Att1.TEST_Att1;
        String test = mapper.writeValueAsString(c);
        System.out.println(test);

        Competence readValue = mapper.readValue(test, Competence.class);
        System.out.println(readValue.template);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Competence {

        private static final Map<String, AttributeTemplate> templates;
        static {
            templates = new HashMap<>();
            Stream.of(Att1.values()).forEach( a -> templates.put(a.name(), a));
            Stream.of(Att2.values()).forEach( a -> templates.put(a.name(), a));
        }

        @JsonProperty
        String nome;
        @JsonProperty
        String desc;
        @JsonIgnore
        AttributeTemplate template;

        @JsonProperty("template_type")
        public String getTempl() {
            // Here you can do whichever way uou would like to serialise your template. This will be the key
            return template.toString();
        }

        @JsonCreator
        public static Competence create(@JsonProperty("template_type") String templateType) {
            Competence c = new Competence();
            c.template =  templates.get(templateType);
            return c;
        }
    }

    public static interface AttributeTemplate {
    }

    public static enum Att1 implements AttributeTemplate {
        TEST_Att1;
    }

    public static enum Att2 implements AttributeTemplate {

        TEST2_Att2;
    }
}