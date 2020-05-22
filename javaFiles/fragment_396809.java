@Test
public void testView() throws Exception {
    String fooId = "fooId";
    Foo foo = new Foo(fooId);
    when(mockFooService.getFoo(fooId)).thenReturn(foo);

    mockMvc.perform(get("/foo/view/" + fooId))
            .andExpect(status().isOk())
            .andExpect(model().attribute("fooId", fooId))
            .andExpect(model().attributeExists("foo"))
            .andExpect(forwardedUrl("foo/view"));
}