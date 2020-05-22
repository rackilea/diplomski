Date d =  new SimpleDateFormat("yyyy-MM-dd").parse("2014-10-12");
Long count = (Long) session.createCriteria(Visit.class)
           .setProjection(Projections.rowCount())
           .add(Restrictions.eq("visitor.id", 1L))
           .add(Restrictions.sqlRestriction("trunc(date)=?", d, org.hibernate.type.StandardBasicTypes.DATE))
           .uniqueResult()  ;