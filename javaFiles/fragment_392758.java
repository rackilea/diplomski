WSRequest req = WS.url("https://graph.facebook.com/100001789213579");
Promise<HttpResponse> respAsync = req.getAsync();
HttpResponse resp = await(respAsync);

JsonElement jsonResp = resp.getJson();
JsonObject jsonObj = new JsonObject();
jsonObj.add("facebook-response", jsonResp);

renderJSON(jsonObj);