@RequestMapping( value="{id}", method = RequestMethod.GET)
public Foo getFoo( @PathVariable(value="id") Long id )
{
    LOG.info("Getting Foo by ID: " + id);

    Foo foo = fooQuery.getFoo( id );
    MyUtil.validate(foo != null, "errorMessageCode");

    ... process foo
    return foo;
}