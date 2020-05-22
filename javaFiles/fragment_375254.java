@EnableAutoConfiguration(exclude = {
org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration.class,
org.springframework.boot.autoconfigure.security.FallbackWebSecurityAutoConfiguration.class,
org.springframework.boot.autoconfigure.security.oauth2.OAuth2AutoConfiguration.class
})