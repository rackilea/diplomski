int i = 0;
boolean continue = true;
while (continue){
    if (result.has("set" + i){

    JSONObject set = result.get("set" + i.toString());

    if (set.has("title"){
        question_list.add(set.getString("title");
    }
    if (set.has("answer"){
        answer_list.add(set.getString("answer");
    }
    if (set.has("imgUrl"){
        image_list.add(set.getString("imgUrl");
    }
    if (set.has("id"){
        question_batch.add(set.getInt("id");
    }

    i++;

    }else{
        continue = false;
    }
}