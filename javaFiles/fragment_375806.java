public boolean isLinkableAssociation(PersistentProperty<?> property) {

    if (property == null || !property.isAssociation()) {
        return false;
    }

    ResourceMetadata metadata = mappings.getMetadataFor(property.getOwner().getType());

    if (metadata != null && !metadata.isExported(property)) {
        return false;
    }

    metadata = mappings.getMetadataFor(property.getActualType());
    return metadata == null ? false : metadata.isExported();
}