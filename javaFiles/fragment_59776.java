DefaultObjectWrapperBuilder owb = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
owb.setMethodAppearanceFineTuner(new MethodAppearanceFineTuner() {
    @Override
    public void process(MethodAppearanceDecisionInput in, MethodAppearanceDecision out) {
        out.setMethodShadowsProperty(false);
    }
});
cfg.setObjectWrapper(owb.build());