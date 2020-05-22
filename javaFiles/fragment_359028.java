try {
            JSONObject object = new JSONObject(result);
            JSONArray arr = object.getJSONArray("list");

            for (int i = 0; i <arr.length() ; i++) {
                JSONObject jsonpart = arr.getJSONObject(i);
                JSONArray mes = jsonpart.getJSONArray("weather");
                for (int j = 0; j <mes.length() ; j++) {
                    JSONObject weatherpart = mes.getJSONObject(j);
                    Log.i("Main",weatherpart.getString("main"));
                    Log.i("Description",weatherpart.getString("description"));
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }