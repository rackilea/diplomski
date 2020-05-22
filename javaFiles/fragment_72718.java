Calendar cal = Calendar.getInstance();
// today 
Date toDate=cal.getTime(); 
cal.add( Calendar.DATE, -30 );
//date before 30 days
Date fromDate=cal.getTime();


Criteria criteria = session.createCriteria(Make.class , "m")
        .createAlias("models", "s")
        .add(Restrictions.between("s.modelCreationDate",  fromDate, toDate))
        // if the above condition dosen't give you exact result you may try following(2)
        // try gt or lt ... as needed 
        //.add(Restrictions.ge("publicationDate", fromDate)) 
        //.add(Restrictions.le("publicationDate", fromDate))
        .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

List<Make> ll2 = criteria.list();