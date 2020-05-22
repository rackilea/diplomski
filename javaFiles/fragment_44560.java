VersionOld version = commonClient.authorizedRequestBuilder(commonClient.webTarget
            .path("/apps/get_current_version/default/"+appName+"/"+appName)
            .queryParam("object_type", "app"))
            .accept(MediaType.APPLICATION_JSON_TYPE)
            .get(javax.ws.rs.core.Response.class)//or get().readEntity(VersionOld.class);
            .readEntity(VersionOld.class);