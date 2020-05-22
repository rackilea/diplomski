public class Request {
    public static void main(String[] args) throws IOException {
        String json = "{\"subItems\":[" +
                          "{\"name\":\"complexType\",\"functionName\":\"SomeFunction\"}," +
                          "\"simpleType\"" +
                      "]}";
        Request request = new ObjectMapper().readValue(json, Request.class);
        System.out.println(request);
    }

    private List<Item> subItems;
    public Request() {
    }
    public Request(Item... subItems) {
        this.subItems = Arrays.asList(subItems);
    }
    public List<Item> getSubItems() {
        return this.subItems;
    }
    public void setSubItems(List<Item> subItems) {
        this.subItems = subItems;
    }
    @Override
    public String toString() {
        return "Request [subItems=" + this.subItems + "]";
    }
}