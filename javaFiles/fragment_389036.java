HttpClient client =  HttpClientBuilder.create().build();
HttpPost postRequest = new HttpPost("http://localhost:8080/departure/");
JSONObject jsonObject = new JSONObject();
jsonObject.put("departDate",dateChooser.getPromptText());
jsonObject.put("time",timeField.getText());
jsonObject.put("flight",flightField.getText());
jsonObject.put("destination",destField.getText());
jsonObject.put("statusTime",statusTimeField.getText());
jsonObject.put("terminal",terminalField.getText());
StringEntity se = new StringEntity(jsonObject.toString());
se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,"application/json"));
postRequest.setEntity(se);

HttpResponse response = client.execute(postRequest);