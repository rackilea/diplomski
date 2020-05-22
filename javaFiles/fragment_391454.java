class MockConfigMapExtension implements IAnnotationDrivenExtension<MockConfigMap> {

    @Override
    void visitSpecAnnotation(MockConfigMap annotation, SpecInfo spec) {
        // WRITE THE RELEVANT STARTUP CODE HERE
    }

    @Override
    void visitFeatureAnnotation(MockConfigMap annotation, FeatureInfo feature) {
    }

    @Override
    void visitFixtureAnnotation(MockConfigMap annotation, MethodInfo fixtureMethod) {
    }

    @Override
    void visitFieldAnnotation(MockConfigMap annotation, FieldInfo field) {
    }

    @Override
    void visitSpec(SpecInfo spec) {
    }
}