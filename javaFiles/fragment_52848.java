@RequestMapping( method=RequestMethod.GET )
public List<JSONRepresentation> getJSONRepresentation( @RequestParam(required=false) Map<String, String> filterParams ) throws ObjectNotFoundException
{
   if(filterParams != null) {
    // DO STUFF AND FILTER ON VALID PARAMETERS.
   } else {
   // DO STUFF AND RETURN ALL.
   }

}