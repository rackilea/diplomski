@Override
public Restlet createInboundRoot() {
    Router router = (...)

    Verifier verify = new MyVerifier(...);
    Enroler enroler = new MyEnroler(...);

    ChallengeAuthenticator guard = new ChallengeAuthenticator(getContext(),
            ChallengeScheme.HTTP_BASIC, "connector");
    guard.setVerifier(verifier);
    guard.serEnrole(enroler);
    guard.setNext(router);

    return guard;
}