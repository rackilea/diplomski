Query query = session.createQuery("SELECT p, "
    + " (SELECT COUNT(*) FROM stat WHERE parent_id=p.id) "
    + " FROM " + Parent.class.getSimpleName() + " p " +
    + " LEFT JOIN FETCH p.children ");
for (Object[] row : (List<Object[]>)query.list()) {
    Parent p = (Parent)row[0];
    p.setSomeCount(((Number)row[1]).longValue());
}