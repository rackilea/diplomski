@Autowired 
    private WebApplicationContext webApplicationContext;

    @Test
    public void uploadMultipartTestFile() throws Exception {
     MockMultipartFile correctFile = new MockMultipartFile("file", "filename.txt", "text/plain", "C:\\temp\\test.txt".getBytes());        
     MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
     when(fileContainerValidator.supports(any(Class.class))).thenReturn(true);
     mockMvc.perform(MockMvcRequestBuilders.fileUpload("/upload")
                .file(correctFile)
                .param("destination", "/tmp"))
                .andExpect(content().string("redirect:/upload")
                 );
    }