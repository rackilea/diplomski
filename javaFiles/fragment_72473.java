Observable<Integer> o = Observable.defer(() -> {
    return Observable.range(1, 10)
            .map(new Func1<Integer, Integer>() {
                int sum;
                @Override
                public Integer call(Integer v) {
                    sum += v;
                    return sum;
                }
            });
});

o.subscribe(System.out::println);
o.subscribe(System.out::println);