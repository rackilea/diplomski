private void getSqlDetails() {

    String url= "http://sbms.atwebpages.com/SB/test.php?id=5";  <--- update your URL like this
    pd.show();
    StringRequest stringRequest = new StringRequest(Request.Method.GET,
            url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {    
                    result.setText(response);   <---- only one line here on this `onResponse` method
                }