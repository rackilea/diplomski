JSONObject urlParameters = new JSONObject();
    jsonParam.put("action", "insert");
    jsonParam.put("author", "barbara");
    jsonParam.put("client", "mike");
   jsonParam.put("text", "hello");

//Send request
  DataOutputStream wr = new DataOutputStream (
              conn.getOutputStream ());
  wr.writeBytes (URLEncoder.encode(urlParameters.toString(),"UTF-8");
  wr.flush ();
  wr.close ();