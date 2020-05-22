@Test
public void sandwiches() {
    final Observable<String> peanutButters = Observable.just("chunky", "smooth")
        .startWith("--initial--");

    final Observable<String> jellies = Observable.just("strawberry", "blackberry", "raspberry")
        .startWith("--initial--");

    Observable.combineLatest(peanutButters, jellies, (peanutButter, jelly) -> {
        return new Pair<>(peanutButter, jelly);
    })
    .subscribe(
        next -> {
            final String peanutButter = next.getFirst();
            final String jelly = next.getSecond();

            if(peanutButter.equals("--initial--") && jelly.equals("--initial--")) {
                // initial emissions
            } else if(peanutButter.equals("--initial--")) {
                // jelly emission
            } else if(jelly.equals("--initial--")) {
                // peanut butter emission
            } else {
                // peanut butter + jelly emissions
            }
        },
        error -> {
            System.err.println("## onError(" + error.getMessage() + ")");
        },
        () -> {
            System.out.println("## onComplete()");
        }
    );
}