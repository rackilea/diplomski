@Test
public void getterMethod() throws Exception{
    mockMvc.perform(get("/path?id=1")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(jsonPath("$[0].id", is(2)))
        .andExpect(jsonPath("$[0].user.userId", is(2)))
        .andExpect(jsonPath("$[0].user.firstName", is("Some")))
        .andExpect(jsonPath("$[0].user.lastName", is("Name")))
        .andExpect(jsonPath("$[0].isYoung", is(false)))
        .andExpect(jsonPath("$[0].isOk", is(false)));
}