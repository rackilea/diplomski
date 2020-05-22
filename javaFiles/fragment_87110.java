RedeemablePromise<Result> promise = RedeemablePromise.empty();

kafkaProducer.send(record, (metadata, ex) -> {
    if (ex != null) {
        promise.failure(ex);
    } else {
        promise.success(created(Json.toJson(new ProduceResult())));
    }
});