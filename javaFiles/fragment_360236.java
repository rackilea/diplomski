@Test
public void testSomething(){

    String xyz = "";
    Integer i = 10;

    // alt 1:
    SomeClass stub = new SomeClass(xyz, i);

    // alt 2: 
    SomeClass stub = new StubSomeClass(xyz, i); // StubSomeClass extends SomeClass

    // alt 3: 
    SomeClass stub = new SomeClass() {
         @Override
         String getProperty1() {
             return xyz;
         }
         @Override
         Integer getProperty2() {
             return i;
         }
    }

    Gson gson = new Gson();
    String json = gson.toJson(stub);

    this.mockmvc.perform(put("/someUrl/")
        .contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isOk());
}