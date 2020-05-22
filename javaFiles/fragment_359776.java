public String placeLimitOrder(String amount,String pair,String price,String side) throws IOException, BadResponseException
{
    Long lnonce=new Date().getTime();
    String nonce=lnonce.toString();
    String req="amount="+amount+"&nonce="+nonce+"&pair="+pair+"&price="+price+"&side="+side+"&type=limit";
    String operation="orders/";
    String signature=getSignature(req);
    URL url = new URL(baseUrl+operation);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("POST");
    con.setDoOutput( true );
    con.setInstanceFollowRedirects( false );

    con.setRequestProperty("Authorization", "TDAX-API "+this.key);
    con.setRequestProperty("Signature",signature);
    con.setRequestProperty("Content-Type", "application/json"); 
    con.setRequestProperty("charset", "utf-8");
    con.setRequestProperty("User-Agent", "java client");
    con.setUseCaches( false );

    JsonObject obj=new JsonObject();
    obj.addProperty("amount", amount);
    obj.addProperty("nonce", nonce);
    obj.addProperty("pair", pair);
    obj.addProperty("price", price);
    obj.addProperty("side", side);
    obj.addProperty("type", "limit");
    String json=obj.toString();

    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(json);
    wr.flush();
    wr.close();

    int responseCode=con.getResponseCode();

    if(responseCode!=HttpURLConnection.HTTP_OK){
        throw new BadResponseException(responseCode);
    }
    BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));

    StringBuilder result = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
        result.append(line);
    }
    rd.close();
    return result.toString();
}