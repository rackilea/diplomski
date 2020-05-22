public String apiURL(String... params) {
    if(params.length == 0) return type.application_url;
    return type.application_url 
        + "?" 
        + IntStream.range(0, params.length)
                   .mapToObj(i -> String.format("param%d=%s", i, params[i]))
                   .collect(Collectors.joining("&"));