Observable<AggregateResponse> aggregateResponse = Observable.
            zip(callServiceA(endpoint)
                            .timeout(5, TimeUnit.SECONDS)
                            .onErrorReturn(throwable -> new Mashup()),
                    callServiceB(endpoint)
                            .timeout(5, TimeUnit.SECONDS)
                            .onErrorReturn(throwable -> new Mashup()),
                    callServiceC(endpoint)
                            .timeout(5, TimeUnit.SECONDS)
                            .onErrorReturn(throwable -> new Mashup()),
                    (Mashup resultA, Mashup resultB, Mashup resultC) -> {
                        AggregateResponse result = new AggregateResponse();
                        result.setResult(resultA.getName() + " " + resultB.getName() + " " + resultC.getName());
                        return result;
                    });