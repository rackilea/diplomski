public void configure(Activity activity, String clientOptions,
    String appId, Iterable<String> zoneIds) {
    // Actual work here
}

// Convenience overload
public void configure(Activity activity, String clientOptions,
    String appId, Iterable<String> zoneIds) {
    configure(activity, clientOptions, appId, Lists.asList(zoneIds));
}