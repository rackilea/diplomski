List<Api> collect = apis
                .stream().filter(
                        api -> (api.getConfigs().stream()
                                .filter(singleConfig -> singleConfig.usersegment.contains("11")
                                        && singleConfig.country.equals("M1"))
                                .count() > 0))
                .collect(Collectors.toList());