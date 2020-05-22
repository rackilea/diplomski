import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends ResourceServerConfigurerAdapter{


    @Override
    public void configure(ResourceServerSecurityConfigurer config) { 
        config
        .tokenStore( createTokenStore() );
    }

    private TokenStore createTokenStore(){
        return createJwkTokenStore();
    }    

    @Bean
    @Primary
    public TokenStore createJwkTokenStore() {         
        try{ return new JwkTokenStore( "http://localhost:8080/auth/jwks" ); }
        catch(Exception e){ throw new RuntimeException(e); }
    } 

}