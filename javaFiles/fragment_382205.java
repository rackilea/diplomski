@Test
        public void loginOk() throws Exception {
            this.mockMvc.perform(post("/login").param("username", "name")
                    .param("password", "1111" )).andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
        }