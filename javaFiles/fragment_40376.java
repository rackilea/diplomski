ObservableInteger obInt = new ObservableInteger();

    Subscription s = obInt
            .getObservable()
            .subscribe(
                    integer -> {
                        // each time a new value is set
                        // it will be emitted here
                    },
                    Throwable::printStackTrace
            );