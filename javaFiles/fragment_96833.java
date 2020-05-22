public Long getStateTypeNumber(StateType type)
{   
    DetachedCriteria maxDateQuery = DetachedCriteria.forClass(State.class);     
    maxDateQuery.setProjection(Projections.projectionList().
            add(Projections.max("date")).
            add(Projections.groupProperty("team")));

    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(State.class);
    criteria.add(Subqueries.propertiesIn(new String[] {"date", "team"}, maxDateQuery));
    criteria.add(Restrictions.eq("type", type));
    criteria.setProjection(Projections.rowCount());
    return (Long) criteria.uniqueResult();      
}