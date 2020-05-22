public class MessageSourceTest {

    @Rule
    public ExpectedException expEx = ExpectedException.none();

    @Test
    public void test() {

        expEx.expectMessage("No message found under code 'email.subject' for locale 'en_CA'");

        Locale.setDefault(Locale.CANADA);

        Locale.forLanguageTag("en");

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:nonexistingResourceBundleButDoesntMatter");
        messageSource.getMessage("email.subject", null, Locale.getDefault().stripExtensions());
    }
}