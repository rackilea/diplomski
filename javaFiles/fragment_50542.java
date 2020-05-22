/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
private EList<String> getEntityTypesGen() {
    if (entityTypes == null) {
        entityTypes = new EDataTypeUniqueEList<String>(String.class, 
            this, NsPackage.THINGY__ENTITY_TYPES);
    }
    return entityTypes;
}

public EList<String> getEntityTypes() {
    return ECollections.unmodifiableEList(getEntityTypesGen());
}

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 */
public void addEntityType(String type) {
    getEntityTypesGen().add(type);
}

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 */
public void removeEntityType(String type) {
    getEntityTypesGen().remove(type);
}