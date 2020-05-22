public List<User> getUsersByPick(int pickId) {
        Criteria criteria = session.createCriteria(User.class)
        .createCriteria("userPicks", "picks")
        .createCriteria("pick", "pick")
        .add( Restrictions.eq("pick.id",pickId) );
        return criteria.list();
    }