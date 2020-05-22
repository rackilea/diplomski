Set<String> managers = managerStoreIdList.stream().map(ManagerStoreId::getManager)
    .collect(Collectors.toSet());

List<String> managerNotFoundInManagerStoreIdList = Manager.stream()
    .filter(m -> !managers.contains(m))
    .collect(Collectors.toList());