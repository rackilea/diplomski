validateProduct(payload)
.map.(r -> {
    if(r.getBoolean("valid")){
        return createProduct(productPayload);
    }else{
        return createEmptyProduct(); // generate non null placeholder object
    }
})
.filter(r->{
    // check here via method call or instanceOf to filter out empty products
    r instanceof ValidProduct
}).map(r -> {
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