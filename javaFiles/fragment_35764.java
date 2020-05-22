@RequestMapping(method = POST)
@ResponseStatus(OK)
public Object post(
    @MultiMapRequestBody final Multimap<String, Object> multimap
) {
    ...
}