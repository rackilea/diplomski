@Override
@Transactional()
public boolean persistUser(User entity) {
    boolean result;
    result = userDao.persist(entity);
    return result;
}