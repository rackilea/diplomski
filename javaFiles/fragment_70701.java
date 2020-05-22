@Override
@Transactional(rollbackFor = java.lang.Exception.class, noRollbackFor = java.io.FileNotFoundException.class, propagation = Propagation.REQUIRES_NEW)
public <T> List<T> findAll(Class<T> type) {
    List<T> list = genericDAOImpl.findAll(type);
    return list;
}