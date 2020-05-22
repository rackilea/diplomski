@Override
public int getNextValue(String sequenceName, boolean autoInit)
{
    Session session = this.getCurrentSession();

    SequenceEntity seq = (SequenceEntity) session.createCriteria(SequenceEntity.class)
        .add(Restrictions.eq("name", sequenceName))
        .setLockMode(LockMode.PESSIMISTIC_WRITE)
        .uniqueResult();
    if (seq == null)
    {
        if (!autoInit)
        {
            throw new SequenceException("Sequence '" + sequenceName + "' must be initialized first.");
        }
        seq = this.initializeSequence(sequenceName);
    }

    seq.incValue();

    session.update(seq);
    session.flush();

    // return the new value
    return (seq.getValue());
}