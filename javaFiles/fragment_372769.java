@Override
@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
public List<E> findByExample(final E exampleEntity) {
    final Example example = Example.create(exampleEntity).excludeZeroes().enableLike();
    return this.session.createCriteria(this.domainClass).add(example).list();
}