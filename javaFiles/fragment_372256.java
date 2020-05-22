public void addState() {
    try {
        State state=new State();
        state.setStateName("Delhi");
        stateDao.create(state);
        addCity();
        addCustomer();
    }
    catch(Exception e) {
        e.printStackTrace();
    }
}