double RATE = 0; // initialize RATE

JSONObject json;
try {
    // do something
     RATE = json.getDouble("v"); // calculate values for RATE, if try fail 
                                 //before assign value RATE will be 0
 } catch (IOException e) {

 } catch (JSONException e) {

 }

 total.setText(String.valueOf(RATE*AMOUNT)); // so still RATE 0 and 
                                             //wrong calculation