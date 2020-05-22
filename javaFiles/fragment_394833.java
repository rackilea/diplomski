ArrayList<String> alPersonType;
  i=0; // initialise your variable once instead of each time in task

public getWorkingIdsFromAPI(ArrayList<String> arrayList) {
    alPersonType = new ArrayList<>(arrayList);
}
@Override
protected Void doInBackground(Void... params) {


    final HttpHandler httpHandler = new HttpHandler();

    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
                       @Override
                       public void run() {
                           if(i < 200) { String JSONString = httpHandler.makeServiceCall("https://api.themoviedb.org/3/movie/" + i + "?api_key=" + API_KEY);

                               if (JSONString != null) {
                                   try {
                                       JSONObject jsonObject = new JSONObject(JSONString);
                                       JSONArray jsonArray = jsonObject.getJSONArray("genres");

                                       boolean cont = true;

                                       for (int a = 0; a < jsonArray.length(); a++) {

                                           JSONObject jsonObject1 = jsonArray.getJSONObject(a);
                                           String string = jsonObject1.getString("name");

                                           for (int b = 0; b < alPersonType.size(); b++) {
                                               if (string.equals(alPersonType.get(b))) {
                                                   cont = false;
                                               }
                                           }
                                       }

                                       if (cont) {
                                           String id = String.valueOf(jsonObject.getInt("id"));
                                           System.out.println("ID:   " + id);

                                           switch (id.length()) {
                                               case 1:
                                                   id = "0000" + id;
                                                   break;
                                               case 2:
                                                   id = "000" + id;
                                                   break;
                                               case 3:
                                                   id = "00" + id;
                                                   break;
                                               case 4:
                                                   id = "0" + id;
                                                   break;
                                           }
                                           switch (i) {
                                               case 1:
                                                   STRING_LIST_OF_IDS = STRING_LIST_OF_IDS + id;
                                                   break;
                                               default:
                                                   STRING_LIST_OF_IDS = ", " + STRING_LIST_OF_IDS + id;
                                                   break;
                                           }
                                       }

                                   } catch (JSONException e) {
                                       e.printStackTrace();
                                   }i++;//increase the counter 
                               }
                           }
                       }
                   }

            , 3000);return null;
}