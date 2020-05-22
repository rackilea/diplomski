URL url = new URL("http://example.com/acct/StatsClientListService"
        + "?clientType=AllClient&something=interesting");
Stream.of(url.getQuery().split("&"))
        .collect(Collectors.toMap(
                s -> s.replaceFirst("^(.*)=.*", "$1"), 
                s -> s.replaceFirst("^.*=(.*)", "$1")))
        .forEach((k, v) -> 
                System.out.printf("param: %s  value: %s%n", k, v)
        );