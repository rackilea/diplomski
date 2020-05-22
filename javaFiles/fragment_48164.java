class GetData extends AsyncTask<String, Void, List<String>> {
   List<String> list;

   protected void onPreExecute(){
        super.onPreExecute();
        list=new ArrayList<>();
    }

    @Override
    protected String doInBackground(String... params) {
        {
            try {
                String username1 = params[0];

                String link = "http://10.0.3.2//Traccar/getCars.php";
                String myurl = "username=" + username1;
                URL url = new URL(link);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.getOutputStream().write(myurl.getBytes());
                int response = connection.getResponseCode();
                Log.d("Response code", "" + response);

                if (response == HttpURLConnection.HTTP_OK) {
                    String line;
                    InputStreamReader isr = new InputStreamReader(connection.getInputStream());
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder buffer = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        buffer.append(line);
                        //res+=line;
                    }

                    Log.d("Result is", buffer.toString());
                    res = buffer.toString();
                    Log.d("res = ", res);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try{
            JSONArray jrr =  new JSONArray(res);
            for (int i=0; i<jrr.length(); i++) {
                JSONObject obj = jrr.getJSONObject(i);
                String name = obj.getString("car_number");
                list.add(name);
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        return list;
    }


    protected void onPostExecute(List<String> res) {

        adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1, res);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);


    }
}