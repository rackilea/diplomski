public class Example {
    public static void main(String[] args) throws Exception {
        String json = "[{\"name\":\"random\"},{\"name\":\"random\"},{\"name\":\"random\"}]";
        ObjectMapper mapper = new ObjectMapper();
        ContactInfo[] contactInfos = mapper.readValue(json, ContactInfo[].class);
        System.out.println(contactInfos.length);
    }

    static class ContactInfo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    } 
}