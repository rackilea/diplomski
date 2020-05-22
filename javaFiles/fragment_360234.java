@RequestMapping(value="/sparql/service", produces={"application/rdf+xml;charset=utf-8", MediaType.ALL_VALUE})
public @ResponseBody String serviceDescriptionAsRdfXml()
{
    return null; // something here
}

@RequestMapping( value="/sparql/service", produces={"text/turtle;charset=utf-8"} )
public @ResponseBody String serviceDescriptionAsTurtle( final HttpServletRequest request )
{
    return null; // something here
}