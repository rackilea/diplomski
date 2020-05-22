String json1 = "{ \"event\":\"test\", \"eventInfo\": \"\" }";
String json2 = "{\"event\":\"test\",\"eventInfo\":{\"name\":\"abc\",\"last\":\"def\"}}";
ObjectMapper mapper = new ObjectMapper();
try {
    MyBean bean1 = mapper.readValue(json1, MyBean.class);
    System.out.println(bean1);
    MyBean bean2 = mapper.readValue(json2, MyBean.class);
    System.out.println(bean2);
} catch (IOException e) {
    e.printStackTrace();
}