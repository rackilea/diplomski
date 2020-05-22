@Configuration
@Profile("embedded")
@EnableConfigurationProperties({ LdapProperties.class })
public class EmbeddedLdapConfig {

    private final Environment environment;
    private final LdapProperties properties;

    public EmbeddedLdapConfig(final Environment environment, final LdapProperties properties) {
        this.environment = environment;
        this.properties = properties;
    }

    @Bean
    @DependsOn("directoryServer")
    public ContextSource ldapContextSource() {
        final LdapContextSource source = new LdapContextSource();
        source.setUrls(this.properties.determineUrls(this.environment));
        source.setBase(this.properties.getBase());
        return source;
    }
}