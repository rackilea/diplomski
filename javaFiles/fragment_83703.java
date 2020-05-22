List<RequestAndResponse> reqresp = bodies.stream()
        .map(Request::new)
        .map(req -> new RequestAndResponse(req, service.send(req)))
        .collect(Collectors.toList());

commonAssertions(reqresp);