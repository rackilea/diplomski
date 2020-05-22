if (needToWaitForUserB()) {
  // Create an unredeemed Scala Promise
  scala.concurrent.Promise<Json> unredeemed = PromiseUtility.newPromise();

  // Store it somewhere so you can access it later, e.g. a ConcurrentMap keyed by userId
  storeUnredeemed(userId, unredeemed);

  // Wrap as an F.Promise and, when redeemed later on, convert to a Result
  return F.Promise.wrap(unredeemed.future()).map(new Function<Json, Result>() {
    @Override
    public Result apply(Json json) {
      return ok(json);
    }
  });
}

// [..]
// In some other part of the code where user B connects

scala.concurrent.Promise<Json> unredeemed = getUnredeemed(userId);
unredeemed.success(jsonDataForUserB);