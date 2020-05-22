Date d =  new SimpleDateFormat("yyyy-MM-dd").parse("2014-10-12");
Date maxDate = new Date(d.getTime() + TimeUnit.DAYS.toMillis(1));
Long count = (Long) session.createCriteria(Visit.class)
                .setProjection(Projections.rowCount())
                .add(Restrictions.eq("visitor.id", 1L))
                .add(Restrictions.between("date", d, maxDate))
                .uniqueResult();