try {

        JSONArray jsonArray = jsonObject.getJSONArray();

        for (int i = 0; i < jsonArray.length(); i++) {
            int student_id = jsonObject.getInt("student_id");
            int present = jsonObject.getInt("present");
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }