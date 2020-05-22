/* Add a heartbeat that ensures we don't wait too long between
     * sending responses and some network device kills our connection */
    final Observable<String> heartbeat =
        Observable.interval( 1, TimeUnit.SECONDS ).map(el -> "heartbeat");
    final PublishSubject<String> stopHeartbeat = PublishSubject.create();
    searchResults.subscribe( el -> {}, ex -> {}, () -> stopHeartbeat.onNext( null ) );
    final Observable<String> searchResultsWithHeartbeat =
        searchResults.mergeWith( heartbeat.takeUntil( stopHeartbeat ) );