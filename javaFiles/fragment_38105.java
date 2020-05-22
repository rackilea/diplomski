JSONArray result = jsonObject.getJSONArray("result");

            for (int i = 0; i < result.length(); i++) {

                JSONObject collegeData = result.getJSONObject(i);
                child_name = collegeData.getString("Date");
                address = collegeData.getString("Events");