@Configuration
public class Config {
    @Bean
    public AmazonS3 getClient(){
        //TODO: Pull whatever you need from KMS, create credentials, define region, etc
        return AmazonS3ClientBuilder.standard().withRegion("my region").build();
    }

}