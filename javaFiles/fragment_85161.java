MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8081/user/get")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Ann")))
                .andExpect(jsonPath("$[0].products", hasSize(2)))
                .andExpect(jsonPath("$[1].name", is("John")))
                .andExpect(jsonPath("$[1].products", hasSize(1)))
                .andReturn();
String content = result.getResponse().getContentAsString();
String id = JsonPath.read(content, "[0].id");