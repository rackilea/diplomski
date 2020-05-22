Observable<B> getB() {
  return getA()
    .flatMap(a -> {                  // <-- flatMap here
      if (a.someCondition()) {
        final B b = new B();
        b.setSomeFields(...);
        return Observable.just(b);   // <-- wrap in observable
      }
      if (a.otherCondition()) {
        final B b = new B();
        b.setOtherFields(...);
        return Observable.just(b);   // <-- wrap in observable
      }
      return getC().map(c -> {       // <-- expensive call executed
          B b = new B(...);          //     only when necessary
          b.setC(c);
          return b;
      });
    });
}