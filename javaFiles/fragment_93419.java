protected PersistentEntityImpl() {
    }

    protected PersistentEntityImpl(Organization organization) {
        String entityId = UUIDGenerator.generate();
        String organizationId = organization.getEntityId();
        identifier = new EntityIdentifier(entityId, organizationId);
    }