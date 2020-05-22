private boolean isActionAvailable(Collection<StudentConfiguration> studentConfigs){
    if(studentConfigs != null) {
        if (studentConfigs.stream().anyMatch(sc -> sc.action() == null || !sc.action().equals(Action.DELETE))) {
            return true;
        }
    }
    return false;
}