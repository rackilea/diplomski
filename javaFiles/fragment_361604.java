import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.ldap.LdapProperties;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
@EnableConfigurationProperties({LdapProperties.class, EmbeddedLdapProperties.class})
@ConditionalOnClass(InMemoryDirectoryServer.class)
public class EmbeddedLdapConf {

    private final Environment environment;
    private final LdapProperties properties;


    public EmbeddedLdapConf(Environment environment, LdapProperties properties) {
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