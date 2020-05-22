@Override
public LockInfo lock(final Class<? extends Lockable> clazz, final Serializable id) throws NotFoundException
{
    try
    {
        return hibernateTemplate.execute(new HibernateCallback<LockInfo>()
        {

            @Override
            public LockInfo doInHibernate(Session session) throws HibernateException, SQLException
            {
                Date lockTime = new Date();
                Query q = session.createQuery(String.format("update %1s item set item.lockTime = :lock where item.id = :id and item.lockTime is null", clazz.getSimpleName()))
                                 .setDate("lock", lockTime)
                                 .setParameter("id", id);

                return q.executeUpdate() > 0 ? new LockInfo(clazz, id, lockTime) : null;
            }
        });
    }
    catch (HibernateException ex)
    {
        if (ex.getCause() instanceof NotFoundException)
            throw (NotFoundException) ex.getCause();
        throw ex;
    }
}

@Override
public void unlock(final LockInfo lock) throws NotFoundException, InvalidOperationException, IllegalArgumentException, ObjectNotLockedException
{
    try
    {
        hibernateTemplate.execute(new HibernateCallback<Void>()
        {

            @Override
            public Void doInHibernate(Session session) throws HibernateException, SQLException
            {
                Query q = session.createQuery(String.format("update %1s item set item.lockTime = null where item.id = :id and item.lockTime = :lock", lock.getClazz()
                                                                                                                                                          .getSimpleName()))
                                 .setDate("lock", lock.getLockDate())
                                 .setParameter("id", lock.getId());

                if (q.executeUpdate() == 1)
                    return null;
                else
                    throw new HibernateException(new ObjectNotLockedException(lock.getId()));
            }
        });
    }
    catch (HibernateException ex)
    {
        if (ex.getCause() instanceof NotFoundException)
            throw (NotFoundException) ex.getCause();
        throw ex;
    }

}