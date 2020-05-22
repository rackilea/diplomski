RequestKey.create()
    .clientId(1234) // Builder of the first level for the mandatory field
    .userId(549375349) // Builder of the second level for any of the additional three mandatory fields
    .flowId("flow number") // Builder on the last level allows setting and overriding the three additional mandatory fields
    .timeout(3600*1000) // Builder on the last level allows setting of the optional fields
    .build(); // Create the instance