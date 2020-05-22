private static String findData() {
    Optional<String> optionalHost = getHostName();
    if (optionalHost.isPresent()) {
        String host = optionalHost.get();
        // do something
    } else {
        // otherwise do something else
    }
}