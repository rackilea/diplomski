for (State state : region01.getState()) {
    if (state.eResource() == null) {
       System.err.println(state.getName() + " is not contained in a resource);
       return;
    }
}