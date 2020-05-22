public boolean updateState(State theState) {
    boolean success = false;
    try {
        currentSession=sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theState.getCountry());
        currentSession.saveOrUpdate(theState);
        success=true;
    } catch (Exception e) { }
    return success;
}