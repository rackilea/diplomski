protected boolean isCpInstanceAvailable() {
    try {
        return getCPLocalMember() != null && getCPMembers().get(getMemberValidationTimeout(), TimeUnit.SECONDS).size() > ONE_MEMBER;
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
        LOG.error("Issue retrieving CP Members", e);
    }

    return false;
}

protected ICompletableFuture<Collection<CPMember>> getCPMembers() {
    return Optional.ofNullable(getCPSubsystemManagementService().getCPMembers()).orElseThrow(
            () -> new HazelcastUnavailableException("CP Members not available"));
}

protected CPMember getCPLocalMember() {
    return getCPSubsystemManagementService().getLocalCPMember();
}