Observable.fromCallable(new Callable<List<EventShift>>() {
            @Override
            public List<EventShift> call() throws Exception {
                return shiftDb.getAll();
            }
        }).flatMap(new Func1<List<EventShift>, Observable<EventShift>>() {
            @Override
            public Observable<EventShift> call(List<EventShift> eventShifts) {
                return Observable.from(eventShifts);
            }
        }).map(new Func1<EventShift, ...>() {
            @Override
            public ... call(EventShift eventShift) {
                //...
            }
        })