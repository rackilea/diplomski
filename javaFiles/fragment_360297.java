String urlString = "/acct/StatsClientListService"
        + "?clientType=AllClient&something=interesting";
if (urlString.contains("?")) {
    String query = urlString.substring(urlString.indexOf("?") + 1);
    Stream.of(query.split("&"))
        .collect(Collectors.toMap(
                s -> s.replaceFirst("^(.*)=.*", "$1"),
                s -> s.replaceFirst("^.*=(.*)", "$1")))
        .forEach((k, v)
                -> System.out.printf("param: %s  value: %s%n", k, v)
        );
}