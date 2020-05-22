@Bean
@DependsOn("directoryServer")
@ConditionalOnMissingBean
public ContextSource ldapContextSource() {
    LdapContextSource source = new LdapContextSource();
    if (hasCredentials(this.embeddedProperties.getCredential())) {
        source.setUserDn(this.embeddedProperties.getCredential().getUsername());
        source.setPassword(this.embeddedProperties.getCredential().getPassword());
    }
    source.setUrls(this.properties.determineUrls(this.environment));
    return source;
}