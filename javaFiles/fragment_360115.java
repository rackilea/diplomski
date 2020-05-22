Observable<String> source = Observable.from(
        "A1", "A2", "A3", "B1", "B2", "B3", "C1", "D1");

Observable<List<String>> output = Observable.defer(() -> {
    List<String> buffer = new ArrayList<>();
    return 
            Observable.concat(
                source.concatMap(new Function<String, Observable<List<String>>>() {
                    String lastKey;
                    @Override
                    public Observable<List<String>> apply(String t) {
                        String key = t.substring(0, 1);
                        if (lastKey != null && !key.equals(lastKey)) {
                            List<String> b = new ArrayList<>(buffer);
                            buffer.clear();
                            buffer.add(t);
                            lastKey = key;
                            return Observable.just(b);
                        }
                        lastKey = key;
                        buffer.add(t);
                        return Observable.empty();
                    }
                }),
                Observable.just(1)
                .flatMap(v -> {
                    if (buffer.isEmpty()) {
                        return Observable.empty();
                    }
                    return Observable.just(buffer);
                })
            );
    }
);

output.subscribe(System.out::println);