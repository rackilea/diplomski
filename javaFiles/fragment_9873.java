Foo foo = null;
try {
    foo = restTemplate.getForObject(url, Foo.class, vars);
} catch (HttpClientErrorException ex)   {
    if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
        throw ex;
    }
}