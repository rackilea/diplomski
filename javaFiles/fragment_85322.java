PublishSubject<Token<Integer>> s = PublishSubject.create();

Observable<Token<Integer>> markers = s.filter(x->x.isMarker());

s.buffer(markers).subscribe(
    v->{
        Optional<Integer> reduce = v.stream()
            .filter(t->!t.isMarker())
            .map(t->(ValueToken<Integer>)t)
            .map(ValueToken::get)
            .reduce((a,b)->a+b);
        reduce.ifPresent(System.out::println);
    }
);

s.onNext(value(12));
s.onNext(value(13));
s.onNext(marker()); // will emit 25

s.onNext(value(10));
s.onNext(value(7));
s.onNext(marker()); // will emit 17

s.onNext(value(10));
s.onNext(value(7)); // Not emitting yet