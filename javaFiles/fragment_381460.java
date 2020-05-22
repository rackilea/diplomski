@Test
public void someTest() {
    CollaborationClaimHistory collaborationClaimHistory = Mockito.mock(CollaborationClaimHistory.class);

    ObjectClaimHistory sut = new ObjectClaimHistory(Lists.newArrayList(collaborationClaimHistory));

    ClaimRequest claimRequest = ...;
    Set<Integer> outOfDateCommits = ...;
    int collaborationId = ...;
    Integer parentCollaborationId = ...;
    ClaimConflicts conflicts = ...;

    // set up expectations on the collaborationClaimHistory instance which will be interrogated within the sut
    Mockito.when(collaborationClaimHistory.checkClaim(claimRequest, outOfDateCommits)).thenReturn(true);

    sut.checkClaim(claimRequest, outOfDateCommits, collaborationId, parentCollaborationId, conflicts);

    // assert that the response (which is implicit in th post invocation state of conflicts) is valid
    assertTrue(conflicts.hasCommitConflict(claimRequest.getObjectId(), claimRequest.getClaim(), collaborationId));

    // ... and repeat for other scenarios, multiple CollaborationClaimHistory instances etc
}