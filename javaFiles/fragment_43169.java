/**
 * Copies fields from source to dest. Only copies fields if they are set, have matching name and type as their counterparts in dest.
 */
public static void copyCommonFields(@Nonnull GeneratedMessageV3 source, @Nonnull com.google.protobuf.GeneratedMessageV3.Builder<?> destBuilder) {
    Map<FieldDescriptorKeyElements, Descriptors.FieldDescriptor> elementsInSource = Maps.uniqueIndex(source.getDescriptorForType().getFields(), FieldDescriptorKeyElements::new);
    Map<FieldDescriptorKeyElements, Descriptors.FieldDescriptor> elementsInDest = Maps.uniqueIndex(destBuilder.getDescriptorForType().getFields(), FieldDescriptorKeyElements::new);
    // those two above could even be cached if necessary as this is static info

    Set<FieldDescriptorKeyElements> elementsInBoth = Sets.intersection(elementsInSource.keySet(), elementsInDest.keySet());

    for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : source.getAllFields().entrySet()) {
        Descriptors.FieldDescriptor descriptor = entry.getKey();
        FieldDescriptorKeyElements keyElements = new FieldDescriptorKeyElements(descriptor);
        if (entry.getValue() != null && elementsInBoth.contains(keyElements)) {
            destBuilder.setField(elementsInDest.get(keyElements), entry.getValue());
        }
    }
}

// used for convenient/quick lookups in a Set
private static final class FieldDescriptorKeyElements {
    final String fieldName;
    final Descriptors.FieldDescriptor.JavaType javaType;
    final boolean isRepeated;

    private FieldDescriptorKeyElements(Descriptors.FieldDescriptor fieldDescriptor) {
        this.fieldName = fieldDescriptor.getName();
        this.javaType = fieldDescriptor.getJavaType();
        this.isRepeated = fieldDescriptor.isRepeated();
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, javaType, isRepeated);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FieldDescriptorKeyElements)) {
            return false;
        }
        FieldDescriptorKeyElements other = (FieldDescriptorKeyElements) obj;
        return Objects.equals(this.fieldName, other.fieldName) &&
                Objects.equals(this.javaType, other.javaType) &&
                Objects.equals(this.isRepeated, other.isRepeated);
    }
}