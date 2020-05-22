@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public boolean userExist(String username) {
        try {
            em.createNamedQuery(User.FIND_USER_BY_USERNAME, User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }