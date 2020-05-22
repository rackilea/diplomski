@Mock
private TagService tagService;

@Test
public void yourTest() {
    doReturn(<tag object you want>)
            .when(tagService).getById();
}