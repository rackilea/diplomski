WSRequest rpxRequest = WS.url("https://rpxnow.com/api/v2/auth_info");
        // get RPX
        rpxRequest.setParameter("token", token);
        rpxRequest.setParameter("apiKey", rpxApi);

        HttpResponse res = null;
        try {
            res = rpxRequest.post();
        } catch (JavaExecutionException ex) {
            Log.error("unknown error ", ex);
            Validation.addError("", "Unknown Error: please try again");
            Validation.keep();
            Secure.login();
        } catch (Exception ex) {
            Log.error("Most likely SSL error", ex);
            Validation.addError("", "SSL Error: please try again");
            Validation.keep();
            Secure.login();
        }
        if (res.getStatus() != 200) {
            Log.error("status 200 error");
            Validation.addError("", "Status 200 error: please try again");
            Validation.keep();
            Secure.login();
        }
        JsonElement rpxJson = res.getJson();
        JsonElement profile = rpxJson.getAsJsonObject().get("profile");
        JsonObject profileJson = profile.getAsJsonObject();