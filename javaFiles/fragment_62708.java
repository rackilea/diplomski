@Test
public void getHello() throws Exception {
ObjectMapper mapper = new ObjectMapper();
String result = mapper.writeValueAsString(new UserController().getUsers());
    mvc.perform(MockMvcRequestBuilders.get("/auth").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(result));
}