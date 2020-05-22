public class CustomAttributeSource extends AnnotationJmxAttributeSource implements EmbeddedValueResolverAware {

    private StringValueResolver embeddedValueResolver;

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.embeddedValueResolver = resolver;
    }

    @Override
    public ManagedAttribute getManagedAttribute(Method method) throws InvalidMetadataException {
        ManagedAttribute managedAttribute = super.getManagedAttribute(method);
        if (this.embeddedValueResolver != null) {
            managedAttribute
                    .setDescription(this.embeddedValueResolver.resolveStringValue(managedAttribute.getDescription()));
        }
        return managedAttribute;
    }

    @Override
    public ManagedOperation getManagedOperation(Method method) throws InvalidMetadataException {
        ManagedOperation managedOperation = super.getManagedOperation(method);
        if (this.embeddedValueResolver != null) {
            managedOperation
                    .setDescription(this.embeddedValueResolver.resolveStringValue(managedOperation.getDescription()));
        }
        return managedOperation;
    }

}