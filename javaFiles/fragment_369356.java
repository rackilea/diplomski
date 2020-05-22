public enum CustomFeatures implements Feature {
    @Label("Activates customFeature")
    MY_CUSTOM_FEATURE;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}