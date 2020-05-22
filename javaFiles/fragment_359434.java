@Override
    public Page<T> findAll(@Nullable Specification<T> spec, Pageable pageable) {

        TypedQuery<T> query = getQuery(spec, pageable);
        return isUnpaged(pageable) ? new PageImpl<T>(query.getResultList())
                : readPage(query, getDomainClass(), pageable, spec);
}