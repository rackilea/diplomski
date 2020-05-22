try{
    JSONArray jsonArray = response.getJSONArray("quiz");
    for (int i = 0; i <jsonArray.length();i++) {
        JSONObject _quiz = jsonArray.getJSONObject(i);
        String title_id = _quiz.getString("title_id");
        String question_id = _quiz.getString("question_id");
        String ans = _quiz.getString("answer");
        String q1 = _quiz.getString("question");
        String a1 = _quiz.getString("answer1");
        String a2 = _quiz.getString("answer2");
        String a3 = _quiz.getString("answer3");
        String a4 = _quiz.getString("answer4");

        title.append(title_id);
        ques_id.append(question_id);
        question.append(q1);
        ans1.append(a1);
        ans2.append(a2);
        ans3.append(a3);
        ans4.append(a4);
        answer.append(ans);
    }
}catch(JSONException e){
    e.printStackTrace();
}