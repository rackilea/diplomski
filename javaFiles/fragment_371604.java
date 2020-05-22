this.mockMvc.perform(
    get("/subsystems").accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk()).andDo(
        document("subsystem").withResponseFields(
            fieldWithPath("[].id").description("Subsystem name"),
            fieldWithPath("[].description").description("Subsystem description")));