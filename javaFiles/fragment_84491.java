@Bean
@Qualifier("authRestTemplate")
public RestTemplate getAuthTemplate{
    // create rest template, add auth interceptor
}

@Bean
@Qualifier("tokenRestTemplate")
public RestTemplate getTokenTemplate{
    // create rest template, add token interceptor
}