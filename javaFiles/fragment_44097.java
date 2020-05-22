@Configuration
@Profile("cloud")
public class CloudConfig{
@Bean
public String remoteURL(@Value("${web.remoting.url.base}") String url) {
return url + "/remoting";
}
}

@Configuration
@Profile("!cloud")
public class RemoteConfig{
@Bean
public String remoteURL(@Value("${web.remoting.url.base}") String url, String applicationID) {
return url + "/" + applicationId.toLowerCase() + "server/remoting";
}
}