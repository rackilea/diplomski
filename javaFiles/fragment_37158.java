public NamedList<Object> request(final SolrRequest request, final ResponseParser processor) throws SolrServerException, IOException {

  // ... other code left out

  if( SolrRequest.METHOD.GET == request.getMethod() ) {
    if( streams != null ) {
      throw new SolrException( SolrException.ErrorCode.BAD_REQUEST, "GET can't send streams!" );
    }
    method = new HttpGet( baseUrl + path + ClientUtils.toQueryString( params, false ) );

  // ... other code left out

  }