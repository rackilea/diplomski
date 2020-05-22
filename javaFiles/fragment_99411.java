@RequestMapping(method = GET, produces = "application/hal+json")
public HttpEntity<VertragPagedResources> showAll( /* PARAMS */  ) { 

    // LIKE CODE IN QUESTION ...

    return new HttpEntity<VertragPagedResources>(pagedResources);
}