public Mono<ResponseEntity> processSequentially(ServerHttpRequest request, List<JsonNode> reqBody) {
    RequestData reqData = this.prepareReqMetadata(request, reqBody);

    Mono ret = commonConnector.getApiResponse(reqData);

    reqBody.forEach(jsonNode -> ret.flatMap(resp -> resp.bodyToMono(JsonNode.class))
                                .flatMap(respBody -> getApiResponse(request, metadataRequestBuilder, respBody))
    );

    return ret;
}