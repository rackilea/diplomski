protected void onPostExecute(JSONObject result) {

 try {
if (result != null) 
{
        if(result.getString("message").equals("Successfully logged in"))
        {
           Intent intent = new Intent(ThisActivity.this,NewActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
        Toast.makeText(this,"Invalid credentials",Toast.LENGTH_LONG).show();
        } 
} 
else 
{
   Toast.makeText(getApplicationContext(), "Unable to retrieve any data from 
server", Toast.LENGTH_LONG).show();
}
 } catch (JSONException e) {
            e.printStackTrace();
        }
    }