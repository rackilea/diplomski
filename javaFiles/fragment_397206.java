public ContainerRequest filter(ContainerRequest request) {
    if (user != null ) {
           //...
        } else {
            throw new WebApplicationException(401);
        }
    return request;
}