List<String> collect = apis.stream().flatMap(api ->
    api.getConfigs().stream().filter(
        singleConfig -> singleConfig.userseg.contains("5")
                     && singleConfig.country.equals("M1")
    ).map(config -> api.getApi() + "," + config.getRow())
).collect(Collectors.toList());