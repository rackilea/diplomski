BehaviorSubject<ImmutableMap> bs = BehaviorSubject.create();
Subject<ImmutableMap, ImmutableMap> sync = bs.toSerialized();

forKey(k): bs.map(m -> m.get(k));

refresh(): sync.onNext(importFromDb());