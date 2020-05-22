...

if (ar.succeeded()) { 
    HttpResponse<JsonArray> result = ar.result();
    JsonArray body = result.body();
    System.out.println(body); 
    data.put("data", body.getJsonObject(0));
} else { 
    data.put("data", ar.cause().getMessage());
}

response.write(data.encode());
routingContext.response().end();

...