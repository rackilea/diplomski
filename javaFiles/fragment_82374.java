JSONObject set = result.get("set" + i.toString());

QuestionObject newQuestion = new QuestionObject();

if (set.has("title"){
    newQuestion.setTitle(result.getString("title");
}
if (set.has("answer"){
    newQuestion.setAnswer(result.getString("answer");
}
if (set.has("imgUrl"){
    newQuestion.setImageURL(result.getString("imgUrl");
}
if (set.has("id"){
    newQuestion.setID(result.getInt("id");
}

questionList.add(newQuestion);