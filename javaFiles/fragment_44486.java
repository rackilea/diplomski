public User registerUser(String usr, String pwd) {

    u=em.find(User.class,usr);
    if(u!=null)
    {
        return null;
    }

    //Now saving...
    em.getTransaction().begin();
    em.persist(u); //em.merge(u); for updates
    em.getTransaction().commit();
    em.close();

    return u;
}