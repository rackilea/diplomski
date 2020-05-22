fun StoreTransaction.setProperty(entity: Entity, entityType: String, propName: String, propValue: Comparable<*>) {
    if(!find(entityType, propName, propValue).isEmpty) {
        throw ExodusException("Unique property violation: $propName = $propValue")
    }
    entity.setProperty(propName, propValue)
}