List<Long> ids = new ArrayList<>();
            ids.add(1L);
            ids.add(2L);
            ids.add(3L);
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> userQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = userQuery.from(User.class);
        userQuery.select(userRoot);
        userQuery.where(userRoot.get("id").in(ids));