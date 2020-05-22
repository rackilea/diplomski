mockMvc.perform(post("/model/connection")
                .param("connectionId", "countingCamera1Conn")
                .param("path", "urlPath")
                .param("status", "IN")
                .param("username", "username")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
        ;