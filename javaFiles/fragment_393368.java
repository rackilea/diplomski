@Test
public void testAlertFilterView() throws Exception {
    this.mockMvc.perform(get("/getServerAlertFilters/v2v2v2/").
            .andExpect(status().isOk())
            .andExpect(content().json("{'data':[{'useRegEx':'false','hosts':'v2v2v2'}]}"));
    }