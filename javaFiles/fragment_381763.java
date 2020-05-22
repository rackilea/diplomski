Completable a = computationTaskA();
Completable b = computationTaskB();
Completable c = computationTaskC();
Completable all = Completable.mergeArray(a, b, c);

all.subscribe(
    () -> { /* success all around! */ },
    e -> { /* at least one failure :( */ }
);