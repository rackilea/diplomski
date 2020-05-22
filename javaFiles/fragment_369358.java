@Component
public class FeatureToggler {

   private final FeatureRepository featureRepository;
   private final FeatureManager featureManager;

   private FeatureToggler(FeatureRepository featureRepository, FeatureManager featureManager) {
      this.featureRepository = featureRepository;
      this.featureManager = featureManager;
   }

   @Schedule(fixedRate=60000)
   public void refreshFeatureToggles() {
        featureManager.setFeatureState(new FeatureState(CustomFeatures.MY_CUSTOM_FEATURE, featureRepository.findByName().isActive);
   }


}