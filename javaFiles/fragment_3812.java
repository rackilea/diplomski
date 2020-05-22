em.createNativeQuery("SELECT u.* FROM user u JOIN user_community_organization uco ON "
                + "u.user_id = uco.user_id "
                + "WHERE uco.community_id = ?1 "
                + "AND lower(u.email) = ?2", User.class)
                .setParameter(1, communityId)
                .setParameter(2, email.toLowerCase());