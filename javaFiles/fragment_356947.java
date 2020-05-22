Criteria cr = session.createCriteria(User.class, "user")
                     .createAlias("user.roles", "role", Criteria.INNER_JOIN)
                     .createAlias("user.statuses", "status", Criteria.LEFT_JOIN);
cr.add(Restrictions.or(
           Restrictions.eq("role.roletype", 1),
           Restrictions.and(
               Restrictions.eq("role.roletype", 2),
               Restrictions.eq("status.statusType", 1))));