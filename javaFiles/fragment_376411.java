validateProduct(payload)
.flatMap(r -> {
    if(r.getBoolean("valid")){
        return createProduct(productPayload); // Assuming this returns an observable if not use Observable.just(createProduct(productPayload))
    }else{
        return Observable.empty(); // request.end() | end the chain here with some message as invalid product.
    }
})
.map(r -> {
    return linkCategories(catPayload);
})
.map(r -> {
    return linkTags(tagPayload);
})
.doOnError(e -> log.error(e))
.subscribe(r -> {
    JsonObject response = new JsonObject().put("status", true);
    request.end(response);
}, e -> {
    JsonObject response = new JsonObject().put("status", false);
    request.end(response);
});