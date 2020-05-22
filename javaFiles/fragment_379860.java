List<Details> details = em.createQuery(
        "SELECT NEW  com.sof.type.Details(itr.iteration_name, prj.project_name, itr.isd, itr.ied) " +
        "FROM RetrospectiveInfo retro, " +
        "     IterationInfo itr, " + 
        "     ProjectInfo prj " +
        "WHERE retro.retrospective_id = :userId " +
        "AND retro.project_id = prj.project_id " +
        "AND retro.iteration_id = itr.iteration_id", Details.class)
    .setParameter("userId", userid)
    .getResultList();