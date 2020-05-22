@Transactional
public <S extends T> List<S> saveAll(Iterable<S> entities) {

    Assert.notNull(entities, "The given Iterable of entities not be null!");

    List<S> result = new ArrayList<S>();

    for (S entity : entities) {
        result.add(save(entity));
    }

    return result;
}