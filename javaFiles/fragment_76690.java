ObjectMapper mapp = new ObjectMapper();
mapp.setVisibility(JsonMethod.FIELD, Visibility.ANY);
try {
    json = mapp.writeValueAsString(info);
    info.clear();
    System.out.println("Chat Info in JSON String is :::>  "+json);
} catch (Exception e) {
    e.printStackTrace();
}