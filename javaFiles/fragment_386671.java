@Test
    public void testHistoricalDataImport() throws Exception {
        MockMultipartFile firstFile = new MockMultipartFile("file", "filename.csv", "text/plain", "some CSV data".getBytes());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.fileUpload("/historicaldata/import")
                .file(firstFile);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();
    }