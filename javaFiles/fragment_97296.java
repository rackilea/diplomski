@Test//this still has problems with the apartment...
public void createNewResidentTest() throws Exception {

    Resident resident = new Resident();
    // build resident
    // convert to json string
    mvc.perform(MockMvcRequestBuilders.post("/api/Residents/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
}