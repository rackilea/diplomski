@Test
public void test(@ArquillianResteasyResource Resource api) throws Exception {
    try (final Response response = api.doMagic(new TestUriInfo())) {
        // test magic
    }
}