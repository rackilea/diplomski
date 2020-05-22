class WhateverClassThisIs {
  private provider<A> providesA;

  @Inject
  public WhateverClassThisIs(provider<A> providesA) {
    this.providesA = providesA;
  }

  public whateverMethodThisIs() {
    actorSystem.actorOf(
    new Props(
      new UntypedActorFactory() {
        public UntypedActor create() {
           /// ???? translation: I need an object A here.
           A a = providesA.get();
        }
      })
    );
  }
}