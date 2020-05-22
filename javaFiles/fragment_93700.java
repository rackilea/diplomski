public List<Manager> getAllSubManagers(Manager manager) {
List<Manager> subManagers = ManagerHierarchyRepository.findByReportingManager(manager).stream()
        .map(ManagerHierarchy::getmanager).collect(Collectors.toList());
List<Manager> newSubManagers = new ArrayList<>();
if (!subManagers.isEmpty()) {
    for (int i = 0; i < subManagers.size(); i++) {
        //change '=' to addAll
        newSubManagers.addAll(getAllSubManagers(subManager.get(i)));
    }
    subManagers.addAll(newManagers);
}
return subManagers;
}