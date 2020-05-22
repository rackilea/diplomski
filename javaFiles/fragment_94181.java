ObservableTransformer<String, String> t = 
    upstream -> upstream.filter(s -> s.length() > 0);

Observable.fromArray("a", "b", "", "d", "", "f")
.compose(t)
.subscribe(System.out::println, Throwable::printStackTrace);