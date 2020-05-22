@Test
    public void createItem() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/items")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Book\",\"price\":10,\"quantity\":100}")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("/item/")))
                .andReturn();
    }