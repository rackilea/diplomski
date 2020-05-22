Response response = Response.ok(successResult);

response.getHeaders().put("Access-Control-Allow-Origin", "*");
response.getHeaders().put("Access-Control-Allow-Headers",
        "origin, content-type, accept, authorization");
response.getHeaders().put("Access-Control-Allow-Credentials", "true");
response.getHeaders().put("Access-Control-Allow-Methods",
        "GET, POST, PUT, DELETE, OPTIONS, HEAD");