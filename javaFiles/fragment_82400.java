@Test
@WithMockUser(username = "sure", password = "sure")
public void checkIfContainsAuthenticatedUserAndCreatesComment() throws Exception {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/post/3/comment");

    Comment com = new Comment();
    String name = auth.getName();

    User currentUser = userRepo.findByUsername(name);

    com.setAuthor(currentUser);
    com.setContent("ahdsf");

    request.flashAttr("comment", com);


    mockMvc.perform(request).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/post/{id}/"));


}