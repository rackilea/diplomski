// work with version 1.0.0
    ReleaseId releaseId1 = ks.newReleaseId("org.kie", "test-upgrade", "1.0.0");
    ...

    // Create a session and fire rules
    KieContainer kc = ks.newKieContainer( releaseId1 );
    KieSession ksession = kc.newKieSession();
    ksession.insert(new Message("Hello World"));
    ...

    // upgrade to version 1.1.0
    ReleaseId releaseId2 = ks.newReleaseId("org.kie", "test-upgrade", "1.1.0");
    kc.updateToVersion(releaseId2);

    // continue working with the session
    ksession.insert(new Message("Hello World"));
    ...