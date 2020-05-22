public String createUrl() {
    UriComponentsBuilder base = UriComponentsBuilder.newInstance().scheme("http").host("example.com").path("/en");
    MvcUriComponentsBuilder builder = MvcUriComponentsBuilder.relativeTo(base);
    builder.withMethodCall(on(BookingController.class).getBooking(21)).buildAndExpand(42);

    URI uri = uriComponents.encode().toUri();
    return uri.toString();
}