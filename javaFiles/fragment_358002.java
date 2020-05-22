public class TranslatorTest {
    @Tested Translator tested;
    @Mocked TranslatorWebService transWebServiceDependency;

    @Test public void translateEnglishToGerman() {
        new Expectations() {{
            transWebServiceDependency.performTranslation("House");
            result = "Haus";
        }};

        String translated = tested.translateEnglishToGerman("House");

        assertEquals("Haus", translated);
    }
}