static queryImageUrl(url, query, MediaType contentType = urlencodedMediaType) {
     if(query instanceof Map) {
        query = map2query query
     }

     def uri = "${url}?$query"
     ByteArrayOutputStream baos = new ByteArrayOutputStream()
     try{
       new HTTPBuilder( uri ).get( contentType:ContentType.BINARY ){ resp, reader ->
         baos << reader 
       }
       baos.toByteArray()
     }finally{
       baos.close()
     }
  }