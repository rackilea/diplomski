try {
    if( !hz.isCpInstanceAvailable() ) {
        throw new HazelcastUnavailableException("CPSubsystem is not available");
    }
    ... acquires the lock ...
} catch (HazelcastUnavailableException e) {
    LOG.error("Error retrieving Hazelcast Distributed Lock :( Please check the CPSubsystem health among all instances", e);
    throw e;
}