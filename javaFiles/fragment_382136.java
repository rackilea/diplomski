public Completable doCalulations() {
    return Completable.fromCallable(() -> {
        //some calculations
    })
    .andThen(
        Completable.defer(() -> {
            if (condition.check()) {
                return someCalculation(); //returns Completable
            } else {
                return anotherCalculation(); //returns Completable
            }
        })
    );
}