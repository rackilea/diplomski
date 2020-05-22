cloudFoundryOperations.services()
    .listServiceKeys(ListServiceKeysRequest.builder()
        .serviceInstanceName("service-instance-name")
        .build())
    .map(ServiceKey::getName)
    .subscribe(System.out::println);