WS.FileParam fp = new WS.FileParam(
      new File("d:\\workspace\\ImageShackTest\\sample_picture.png"), "fileupload");

    Map<String,Object> params = new HashMap<String, Object>();
    params.put( "optsize", "resample" );
    params.put( "rembar", "yes" );
    params.put( "public", "yes" );
    //params.put( "a_username", username );
    //params.put( "a_password", password );
    params.put( "key", API_KEY );

    //POST request
    Document doc = WS.url( "http://www.imageshack.us/upload_api.php" )
        .params( params )
        .files( fp )
        .post()
        .getXml();