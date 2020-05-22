public class JSonAliasWithSpecialCharacters {

    public static void main(String[] args) throws IOException {
        String json="{ \"$fooid\" : \"yfdfjjhkjhkljhd768622323jjj\" }";
        ObjectMapper mapper = new ObjectMapper();
        JsonFooid fooid = mapper.readValue(json, JsonFooid.class);
        System.out.println("read the foodid:"+fooid.getFooid());
    }

}

public class JsonFooid {

    @JsonProperty("$fooid")
    private String fooid;

    public String getFooid() {
        return fooid;
    }

    public void setFooid(String fooid) {
        this.fooid = fooid;
    }

}