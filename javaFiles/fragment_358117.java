public void testRetrieveAllHotels_WebLayer(){

  when(businessService.retrieveAllHotels()).thenReturn(
        Arrays.asList(new Hotel(1, "Sofitel", 120, 20),
                new Hotel(2, "Ibis", 50, 40),
                new Item(3, "Marriot", 200, 15)));

  mockMvc.perform(
        get("/items"))
        .andExpect(status().isOk());

  verify(businessService, times(1)).retrieveAllHotels();
}