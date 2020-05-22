Criteria criteria = session.createCriteria( TABLENAME.class );

criteria.add( Restrictions.eq( "IDObject1" , idObjectB) );
criteria.add( Restrictions.eq( "IDObject2" , idObjectB) );
criteria.add( Restrictions.eq( "IDSettingOption" ,idSettingOption) );

List results = criteria.list();