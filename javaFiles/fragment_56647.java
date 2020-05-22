Map<String, String> parameters = new HashMap<>();
parameters.put("path", "test6.txt" );
parameters.put("message","test");
parameters.put("sha", "863ba79d293acda68556bbddc1f97a29cb7b98bf" );
parameters.put("content", "dGVzdDM0Cg==");
parameters.put("branch", "master");
HttpClient httpclient = HttpClients.createDefault();
HttpPut con2 = new HttpPut(https://api.github.com/repos/pedro-roberto/test2/contents/test6.txt);
con2.addHeader("Authorization","token 2******************0");

//tricky part
con2.addHeader("Content-Type", "application/x-www-form-urlencoded");
Gson gson = new Gson();
String json = gson.toJson(parameters);
con2.setEntity(new StringEntity(json));

HttpResponse response = httpclient.execute(con2);