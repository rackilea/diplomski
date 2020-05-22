public static F.Promise<Result> delete() {
    F.Promise<Boolean> promise = isDummyThere(); //rest call to check the exist of the dummy

    return promise.flatMap(aBoolean -> {
        if (!aBoolean) {
            return F.Promise.pure(badRequest("No..i'm not there"));
        }
        return deleteDummy().map(result-> ok());
    });
}