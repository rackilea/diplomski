Set<Parser> parserSet = new HashSet<>();
parserSet.add(new Parser(..., ..., ...));
// Add more parsers 
int numParsers = parserSet.size();

ArrayList<Flowable<T>> parserObservableList = new ArrayList<>();

for (Parser p: parserSet) {
    parserObservableList.add(Flowable.fromCallable(() -> p.parse(f))
                                     .retryWhen(/* Add your retry logic */)
                                     .onErrorReturn(/* some error value */));
}

Flowable.amb(parserObservableList).subscribe(/* do what you want with the results */);