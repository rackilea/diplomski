public class LdapServiceFactory implements Supplier<LdapService<YourType>> {
    @Override
    public LdapService<YourType> get() {
        return createLdapService(DEFAULT_PROPERTIES_FILE);
    }
}