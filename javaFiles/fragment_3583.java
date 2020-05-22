Friend friend = new Friend();
    friend.setUsername(rUser);

return (List<Friend>) hibernateTemplate.findByCriteria(
        DetachedCriteria.forClass(Friend.class)
        .add(Example.create(friend)));