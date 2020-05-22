public class MyAsyncTask extends AsyncTask<Void, Void, ArrayList> {
         JsonArray myJsonArray;
   @Override
    protected void onPreExecute() {
        super.onPreExecute();

            mVolleySingleton = VolleySingleton.getInstance();

            mRequestQueue = mVolleySingleton.getRequestQueue();

            listblogs.clear();

        }
        @Override
        protected ArrayList doInBackground(Void... params) {


            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL_API, (String) null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    myJsonArray = response;

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
            mRequestQueue.add(request);
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList arrayList) {
            super.onPostExecute(arrayList);

              ArrayList<Blogs> blogsArrayList = new ArrayList<>();
    try {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < myJsonArray.length(); i++) {
            JSONObject currentQuestions = myJsonArray.getJSONObject(i);
            String text = currentQuestions.getString("text");
            String points = currentQuestions.getString("points");
            String ID=currentQuestions.getString("id");
            String studentId = currentQuestions.getString("studentId");
            String DateCreated=currentQuestions.getString("created");
            long time=Long.parseLong(DateCreated.trim());
            data.append(text + "\n" + points + "\n");
            System.out.println(data);
            Blogs blogs = new Blogs();
            blogs.setId(ID);
            blogs.setMstudentId(studentId);
            blogs.setMtext(text);
            blogs.setPoints(points);
            //The dateCreated was off by 1 hour so 3600000 ms where added=1hour, (UPDATE)
            blogs.setDateCreated(getTimeAgo(time));
            System.out.println(time+"time");


            blogsArrayList.add(blogs);
            }
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return blogsArrayList;

    }