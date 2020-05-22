try {

        JSONObject mainJsonObject = new JSONObject();

        JSONArray jsonArray = new JSONArray();
        //if more than one then wrap inside loop
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("student_id", value);
        jsonObject.put("present", value);
        jsonArray.put(jsonObject);
        //end loop

        mainJsonObject.put("course_id", value);
        mainJsonObject.put("batch_id", value);
        mainJsonObject.put("subject_id", value);
        mainJsonObject.put("students", jsonArray);

    } catch (JSONException e) {
        e.printStackTrace();
    }