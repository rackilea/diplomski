this.mockMvc.perform(
    get("/subsystems").accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk()).andDo(
        document("subsystem").withResponseFields(
            fieldWithPath("[]").description("An array of subsystems"),
            fieldWithPath("[].id").ignore(),
            fieldWithPath("[].description").ignore()));