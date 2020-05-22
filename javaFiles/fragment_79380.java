HttpHeaders lHttpHeaders = new HttpHeaders();
lHttpHeaders.setContentType( MediaType.APPLICATION_JSON );//or whatever it's in your case
String payload="<PAYLOAD HERE>"
try
{
    String lResponseJson = mRestTemplate.postForObject( url, new HttpEntity<Object>( payload, lHttpHeaders ), String.class);
    return lResponseJson;
}
catch( Exception lExcp )
{
    logger.error( lExcp.getMessage(), lExcp );
}