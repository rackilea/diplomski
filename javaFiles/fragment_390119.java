try {
        TestParse parseObject = ParseObject.createWithoutData(TestParse.class, "tjkbdde0B1");
        JSONObject jsonObject = parseObjectToJson(parseObject);
        Log.d("TAG", jsonObject.toString(4));
    } catch (ParseException | JSONException e) {
        Log.e("TAG", e.getMessage());
    }