public List<Application> getOlderThanNDays( int days )
{
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Application> cq = cb.createQuery( Application.class );
    Root<Application> root = cq.from( Application.class );

    long today = System.currentTimeMillis();
    long nDays = days * 24 * 60 * 60 * 1000;
    long nDaysAgo = today - nDays;
    Date nDaysAgoDate = new Date( nDaysAgo );

    // Is here the response to your question?
    cq.where( cb.lessThanOrEqualTo( root.get(Application_.date), nDaysAgoDate ) );

    TypedQuery<Application> q = entityManager.createQuery( cq );

    List<Application> list = q.getResultList();
    return list;
}