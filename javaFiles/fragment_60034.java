public String makeUrl(HttpServletRequest request, String param, String value) {
    ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
    builder.queryParam(param, value);
    URI uri = builder.build().toUri();
    return uri.toString();
}