@Test
public void JSON() {
    Gson gson = new Gson();
    Type listType = new TypeToken<List<MyObject>>(){}.getType();
    // In this test code i just shove the JSON here as string.
    List<Asd> asd = gson.fromJson("[{'name':\"test1\"}, {'name':\"test2\"}]", listType);
}