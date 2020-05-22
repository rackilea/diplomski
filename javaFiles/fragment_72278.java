@Override
@Transactional
public Set<PartyData> insertPartyData(final Set<PartyData> pData) throws DataServiceException
{
    final Session session = sessionFactory.openSession();
    Transaction tx;
    try {
        tx = session.beginTransaction();
        \\read curren db value and do the validation with new data (throw exception if validation fails else continue)
        session.save(pData);
        }
        tx.commit();
    }
    catch (final Exception e) {
        throw new DataServiceException(e);
    }
    finally {
        session.close();
    }
    return pData;
}