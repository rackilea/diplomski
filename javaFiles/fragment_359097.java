@ConditionalOnProperty("newfeature.enabled")
@Configuration
@EntityScan("my.application.features.thefeature")
public class MyFeatureConfiguration {
  /*
  * No Configuration needed for scanning of entities. 
  * Do here whatever else should be configured for this feature.
  */
}