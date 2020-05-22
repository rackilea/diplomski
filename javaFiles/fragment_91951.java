@Test
public void uploadImage() throws Exception {
    String data = "test-data";
    MockMultipartFile imageFile = new MockMultipartFile("image", "my-image.jpeg", "image/jpeg", data.getBytes());
    mockMvc.perform(MockMvcRequestBuilders.fileUpload("/query/att/handle").file(imageFile).param("queId", "123").param("licNo", "12"));
}