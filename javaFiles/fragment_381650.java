Cluster.Builder builder = Cluster.builder();
// Boolean used to check if at least one host could be resolved
boolean found = false;
for (String address : "1,2,3".split(",")) {
    try {
        builder.addContactPoint(address);
        // One host could be resolved
        found = true;
    } catch (IllegalArgumentException e) {
        // This host could not be resolved so we log a message and keep going
        Log.log(
            Level.WARNING, 
            String.format("The host '%s' is unknown so it will be ignored", address)
        );
    }
}
if (!found) {
    // No host could be resolved so we throw an exception
    throw new IllegalStateException("All provided hosts are unknown");
}
Cluster cluster = builder.build();