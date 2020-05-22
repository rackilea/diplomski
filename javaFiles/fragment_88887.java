@Test
    @WithUserDetails( "myUserNameOnDatabase")
    public void contextLoads() {
        try {
            mockMvc.perform(get("/stores")).andExpect(status().isOk()).andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }