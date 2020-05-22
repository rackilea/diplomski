List<String> ipAddresses = Arrays.asList("10.", "132.174.", "192.168.");

List<String> internalIpAddresses = ipAddresses.stream()
        .filter("10.11.12.13"::startsWith)
        .map(ipAddress -> "10.11.12.13")
        .collect(Collectors.toList());

List<String> externalIpAddresses = ipAddresses.stream()
        .filter(ipAddress -> !"5.6.7.8".startsWith(ipAddress)) // I doubt this should be '.filter("5.6.7.8"::startsWith)'
        .map(ipAddress -> "5.6.7.8")
        .collect(Collectors.toList());