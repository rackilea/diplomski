@Test
public void shouldCreateFile() {
    final MyFile mockedMyFile = spy(file);
    final Map<String, Object> rootMap = new HashMap<String, Object>();
    TemplateLoader templateLoader = null;

    try {
        templateLoader = new FileTemplateLoader(new File("<PATH TO TEMPLATE FOLDER>"));
    } catch (final IOException e) {
        e.printStackTrace();
    }

    gerador.setTemplateLoader(templateLoader);
    // the rest
}