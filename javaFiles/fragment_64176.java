CriteriaBuilder builder = em.getCriteriaBuilder();
CriteriaQuery<MyEntity> cq = builder.createQuery( MyEntity.class );
Root<MyEntity> root = cq.from( MyEntity.class );

javax.persistence.criteria.Expression<java.sql.Time> timeDiff = builder.function(
            "TIMEDIFF",
            java.sql.Time.class,
            root.<Date>get( "endDate" ),
            root.<Date>get( "startDate" ) );
javax.persistence.criteria.Expression<Integer> timeToSec = builder.function(
            "TIME_TO_SEC",
            Integer.class,
            timeDiff );

//lessThanOrEqualTo 60 minutes
cq.where( builder.lessThanOrEqualTo( timeToSec, 3600 ) );

return em.createQuery( cq ).getResultList();