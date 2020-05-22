Router router = (...)

    Authorizer authorizer = new MyAuthorizer();
    authorizer.setNext(router);

    Verifier verify = new MyVerifier(...);
    Enroler enroler = new MyEnroler(...);

    ChallengeAuthenticator guard = new ChallengeAuthenticator(getContext(),
            ChallengeScheme.HTTP_BASIC, "connector");
    guard.setVerifier(verifier);
    guard.serEnrole(enroler);
    guard.setNext(authorizer);

    return guard;
}