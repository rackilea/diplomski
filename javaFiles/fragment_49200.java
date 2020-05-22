@Override
public Integer save(ENTITY entity) {
    if (entity.getId() == null) {
        insert(entity);
    } else {
        update(entity);
    }
    return null;
}