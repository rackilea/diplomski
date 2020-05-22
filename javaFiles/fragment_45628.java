else {
    ArrayList<String> QidList = new ArrayList<String>();
    ArrayList<String> QuestionList = new ArrayList<String>();
    Question jsonResponse = response.body();
    message = response.body().getMessage();
    CommonObjects.q.setData(jsonResponse.getData());
    CommonObjects.q.setMessage(message);
    CommonObjects.q.setStatus(response.body().getStatus());
    for (Datum data : jsonResponse.getData()) {
        if((!TextUtils.isEmpty(data.getQId())) && 
                      (!TextUtils.isEmpty(data.getQuestion()))){
             QidList.add(data.getQId());
             QuestionList.add(data.getQuestion());
        }

    }
}