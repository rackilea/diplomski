@Configuration
public class SSLConfiguration {

@Value("${certificate.name}")
private String name;

@Bean(name = "sslContext")
public SSLContext sslContext() throws Exception {
  Security.addProvider(new BouncyCastleProvider());
  return SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).useTLS().build();
}

@Bean(name = "sslSocketFactory")
public SSLSocketFactory sslSocketFactory() throws Exception {

  return new ConnectionFactoryCreator(name, sslContext()).getSocketFactory();

}

@Bean(name = "httpClient")
public HttpClient httpClient() throws Exception {
  return HttpClientBuilder.create().setSslcontext(sslContext())
        .setSSLSocketFactory(new SSLConnectionSocketFactory(sslSocketFactory(), new AllowAllHostnameVerifier()))
        .build();
}

@Bean
public ClientHttpRequestFactory httpClientRequestFactory() throws Exception {
  return new HttpComponentsClientHttpRequestFactory(httpClient());
}

@Bean
public RestTemplate restTemplate() throws Exception {
  return new RestTemplate(httpClientRequestFactory());
 }

}