@Test
public void testException
    mockMvc.perform(post("/exception/path"))
        .andExpect(status().is5xxServerError())
        .andExpect(content().string("Exception body"));
}