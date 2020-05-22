@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
public int getNextValue(String sequenceName)
{
    synchronized (lock)
    {
        return (this.sequenceDao.getNextValue(sequenceName));
    }
}