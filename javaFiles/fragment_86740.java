@RequestMapping(
    method   = RequestMethod.POST,
    value    = { "/{version}/protobuf" },
    consumes = { MediaType.APPLICATION_OCTET_STREAM_VALUE, "application/x-protobuf" },
    produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE, "application/x-protobuf" }
)