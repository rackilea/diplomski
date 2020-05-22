String first_data;
String last_data;

JSONArray users = response.getJSONArray("statistics");
for (int i = 0; i < (users.length()-2); i++) {
    JSONObject student = users.getJSONObject(i);

    String userName = student.getString("username");
    String score = student.getString("score");

    first_data = userName + " " + score + " \n";

}

JSONObject last_student = users.getJSONObject(users.length()-1);
String last_userName = last_student .getString("username");
String last_score = last_student .getString("score");

last_data = last_userName + " " + last_score + " \n";

statistics.append(Html.fromHtml(first_data + "<font color="red">" +last_record +"</font>"));