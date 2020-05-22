Query query = HibernateUtil.getSession().createQuery(
        "select m " +
        "from Member2 m " +
        "join fetch m.club2 c" + 
        "where " +
        "   c.country = :country "
)
.setParameter("country", "UK");