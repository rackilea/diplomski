@Query("select new Stats(" +
        "c.course, " +
        "c.courseType, " +
        "count(c), " +
        "SUM(CASE WHEN win = true THEN 1 ELSE 0 END), " +
        "cpt) " +
        "from Competition cpt " +
        "inner join cpt.betMatches bm " +
        "inner join bm.courses c " +
        "group by c.course, c.courseType, cpt")
@ReadOnlyProperty
public List<Stats> computeStatsByBetShop();