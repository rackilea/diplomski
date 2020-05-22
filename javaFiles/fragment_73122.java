public BehaviorSubject<Profile> observeProfile() {

        if (profileBS == null) {

            profileBS = BehaviorSubject.create();

            Observable o = Observable.combineLatest(
                    Observable.just(userAccount),
                    observeMeasurements(),
                    observeDeadline(),
                    Profile::new
            );

            // Note the following returns a subscription. If you want to prevent leaks you need some way of unsubscribing.
            o.subscribe(profileBS); 

        }
        return profileBS;
}