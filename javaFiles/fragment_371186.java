public void save(Classes transientInstance)
{
    log.debug("saving Classes instance");
    try
    {
        HibernateUtil.getCurrentSession().save(transientInstance);
        log.debug("save successful");
    } catch (RuntimeException re)
    {
        log.error("save failed", re);
        throw re;
    }
}