// return void here
    public void loadQuestions(String sort, String area, String before, String length) {
    final List<QuestionsItem> questions = new ArrayList<>();
    final API api = new API();

    OkHttpClient client = new OkHttpClient();

    RequestBody body = new FormBody.Builder()
            .add("sort", sort)
            .add("area", area)
            .add("before", before)
            .add("length", length)
            .build();

    Request request = api.call("q_loadmore", body, getContext(), getActivity());

    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            MaterialDialog dialog = api.prepareDialog(getContext(), "An Error Occoured", "An Error Occoured. Please make sure you are connected to the internet and try again. If the issue still persists please contact support.");
            dialog.show();
            call.cancel();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            final String responseText = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(responseText);

                        if (jsonObject.get("status").equals("ok"))
                        {
                            JSONObject payload = jsonObject.getJSONObject("payload");
                            JSONArray questionsArray = payload.getJSONArray("questions");

                            // TODO: Set Before String
                            //beforeString = payload.get("before").toString();

                            for (int i=0; i < questionsArray.length(); i++) {
                                JSONObject obj = questionsArray.getJSONObject(i);
                                String id = obj.get("qid").toString();
                                String title = obj.get("title").toString();
                                String postedBy = obj.get("postedBy").toString();
                                int views = obj.getInt("views");
                                int votes = obj.getInt("votes");
                                int answers = obj.getInt("answers");
                                int postedOn = obj.getInt("postedOn");
                                String[] tags = api.toStringArray(obj.getJSONArray("tags"));

                                QuestionsItem questionsItem = new QuestionsItem(id, title, tags, views, votes, answers, postedBy, postedOn);
                                questions.add(questionsItem);
                            }



                       // Set questions array in your adapter class
                       mQuestionAdapter.setQuestions(questions);
                       mQuestionAdapter.notifyDatasetChanged();



                        }
                        else if (jsonObject.get("status").equals("error"))
                        {
                            MaterialDialog dialog = api.prepareDialog(getContext(), jsonObject.getJSONObject("dialog").get("title").toString(), jsonObject.getJSONObject("dialog").get("message").toString());
                            dialog.show();
                        }
                        else
                        {
                            MaterialDialog dialog = api.prepareDialog(getContext(), "An Error Occurred", "An Error Occurred. Please make sure you are connected to the internet and try again. If the issue still persists please contact support.");
                            dialog.show();
                        }

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
        }
    });
// remove return statement
}