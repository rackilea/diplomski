public void asyncJson(){

    //perform a Google search in just a few lines of code

    String url = "http://www.google.com/somesearch";             
    aq.ajax(url, JSONObject.class, this, "jsonCallback");

}

public void jsonCallback(String url, JSONObject json, AjaxStatus status){

    if( json != null ){
        //successful ajax call

        String ipString = "";

        try {
            ipString = json.getString("ip");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("ip", ipString);//do this if you just want to log the ipString

        //or, do this to set the "ip" string into a TextView 
        //referenced by "R.id.mytextview"
        aq.id(R.id.mytextview).text(ipString); //this is shorthand AQuery syntax
    } else {          
        //ajax error
    }

}