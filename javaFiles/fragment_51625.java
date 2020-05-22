@Override
public <T extends Base> T find(Class<T> baseClass, Long id) {
    if (baseClass == null || id == null) {
        throw new DaoLevelException("Entity class or id cannot be null");
    }
    // code for finding with id
}

@Override
public void save(Base base) {
    if (base == null) {
        throw new DaoLevelException("object passed for saving cannot be null");
    }
    // code for persist 
}