String user1 = "{'Main':[{'h1':[ {'userId':'userId123'} ],'body':[{'data': [{'userId':'one'}]}] }]}";

    JSONObject jsonObj = (JSONObject) JSONSerializer.toJSON(user1);
    JSONArray snefoCareEnvelopeMain = (jsonObj.getJSONArray("Main"));                   
    //main object
    JSONObject  Main =  snefoCareEnvelopeMain.getJSONObject(0);

    // this for reading h1 data

    JSONArray  headerarray = (Main.getJSONArray("h1"));
    JSONObject h1=headerarray.getJSONObject(0);
    System.out.println("the first value is :"+h1.getString("userId"));


    //for body
    JSONArray bodyarray=(Main.getJSONArray("body"));
    JSONObject bodyobject=bodyarray.getJSONObject(0);
    JSONArray dataArary=bodyobject.getJSONArray("data");
    JSONObject data=dataArary.getJSONObject(0);
    System.out.println("the body is"+data);