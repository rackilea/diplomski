MockMultipartFile file = new MockMultipartFile("data", "dummy.csv",
            "text/plain", "Some dataset...".getBytes());

    MockMultipartHttpServletRequestBuilder builder =
            MockMvcRequestBuilders.fileUpload("/test1/datasets/set1");
    builder.with(new RequestPostProcessor() {
        @Override
        public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
            request.setMethod("PUT");
            return request;
        }
    });
    mvc.perform(builder
            .file(file))
            .andExpect(status().ok());