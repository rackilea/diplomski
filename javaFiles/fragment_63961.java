private void expectCandidatesFromMap(final Map<String, Long> domainNameToId) {
    Map<String, Candidate> expectedCandidates = new HashMap<String, Candidate>();

    class MockedCandidate extends MockUp<Candidate> {
        private final String domainName;
        private final Long domainId;

        MockedCandidate(String domainName) {
            this.domainName = domainName;
            this.domainId = domainNameToId.get(domainName);
        }

        @Mock Long getDomainId() { return domainId; }
        @Mock String getRepresentingName() { return domainName; }
        @Mock boolean validateAndPrepare() { return true; }
    }

    for (String domain : domainNameToId.keySet()) {
        expectedCandidates.put(domain, new MockedCandidate(domain).getMockInstance());
    }
}