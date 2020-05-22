JsonWebSignature jws = JsonWebSignature.parse(new JacksonFactory(), req.getParameter("SPAppToken"));


    JsonParser jsonParser = new JacksonFactory().createJsonParser(jws.getPayload().get("appctx").toString());

    //Create my own AppTxc that extends GenericJSON
    AppCtx appCtx = jsonParser.parse(AppCtx.class, new CustomizeJsonParser());



    String appctxsender=jws.getPayload().get("appctxsender").toString();
    String[] splitApptxSender = appctxsender.split("@");

    //sharepointhost name is part of the resource field
    String sharepointServerHostName = new URL(req.getParameter("SPHostUrl")).getHost();

    // create the resource field        
    String resource = splitApptxSender[0]+"/"+sharepointServerHostName+"@"+splitApptxSender[1];



    try {

        AuthorizationCodeTokenRequest tokenRequest =    new AuthorizationCodeTokenRequest(new NetHttpTransport(), new JacksonFactory(),
                  new GenericUrl(appCtx.getSecurityTokenServiceUri()), jws.getPayload().get("refreshtoken").toString());

        tokenRequest.setRedirectUri("https://eog-fire-ice.appspot.com/callback4fireandice");
        tokenRequest.setClientAuthentication(
                    new ClientParametersAuthentication(jws.getPayload().getAudience(), SharePointAppSecret));
        tokenRequest.setGrantType("refresh_token");
        tokenRequest.set("resource", resource);
        tokenRequest.set("refresh_token", jws.getPayload().get("refreshtoken").toString());
        TokenResponse response =tokenRequest.execute();



        String accesstoken=response.getAccessToken();

    } catch (TokenResponseException e) {
        if (e.getDetails() != null) {
            pw.println("Error: " + e.getDetails().getError());
            if (e.getDetails().getErrorDescription() != null) {
              pw.println(e.getDetails().getErrorDescription());
            }
            if (e.getDetails().getErrorUri() != null) {
              pw.println(e.getDetails().getErrorUri());
            }
          } else {
            pw.println(e.getMessage());
          }
    }