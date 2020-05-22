@Transactional
public Teen find(String email) {
    return find(email, false);
}

@Transactional
public Teen find(String email, boolean forceLoad) {
    Teen teen = em.find(Teen.class, email);
    if(teen != null && forceLoad) {
        Hibernate.initialize(teen.getUser());
        Hibernate.initialize(teen.getFollowerList());
        Hibernate.initialize(teen.getPendingFollowerList());
        Hibernate.initialize(teen.getCheckInList());
    }
    return teen;
}