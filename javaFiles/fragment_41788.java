String updateQuery = "update Person p set p.status=:pstatus "
                + "where p.id=:pid and (select count(*) from WorkJobs wj "
                + "where wj.status=:wjstatus)=:wjcount and (select count(*) "
                + "from Expences e where e.cost > :ecost)=:ecount";

        BigDecimal maxCost = new BigDecimal(20.0);
        Long pid = new Long(1l);

        Query query = session.createQuery(updateQuery);

        query.setParameter("pstatus", "Happy");
        query.setParameter("pid", pid);
        query.setParameter("wjstatus", null);
        query.setParameter("wjcount", 0l);
        query.setParameter("ecost", maxCost);
        query.setParameter("ecount", 0l);

        int rowCount = query.executeUpdate();