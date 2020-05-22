String uri = UriComponentsBuilder
     .fromUriString(env.getProperty("smsProviderUrl"))
     // Add query parameter     
     .queryParam("user", env.getProperty("smsUser"))
     .queryParam("password", env.getProperty("smsPassword"))
     .queryParam("msisdn", new Object[] {number})
     .queryParam("sid", sendedID)
     .queryParam("msg", body)                           
     .queryParam("fl", env.getProperty("smsFl"))
     .encode()
     .build()
     .toUriString();