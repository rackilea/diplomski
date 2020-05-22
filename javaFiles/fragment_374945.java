List<Long> ids = em.createQuery("SELECT s.id FROM Student s WHERE s.nume = :nume", Long.class)
    .setParameter("nume", nume)
    .getResultList();

em.createQuery("UPDATE Record r SET r.lab_points = :points WHERE b.student_id IN :ids")
    .setParameter("ids", ids)
    .setParameter("points",lab_points)
    .executeUpdate();